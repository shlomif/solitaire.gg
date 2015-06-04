package models.database.queries.game

import java.util.UUID

import com.github.mauricio.async.db.RowData
import models.GameHistory
import models.database.queries.BaseQueries
import models.database.{ Query, Statement }
import org.joda.time.LocalDateTime
import utils.DateUtils

object GameHistoryMoveQueries extends BaseQueries[GameHistory.Move] {
  override protected val tableName = "game_moves"
  override protected val columns = Seq("game_id", "sequence", "player_id", "move", "cards", "src", "tgt", "occurred")
  override protected val searchColumns = Seq("game_id::text", "player_id::text", "move")

  case class GetGameMovesByGame(id: UUID) extends Query[List[GameHistory.Move]] {
    override val sql = getSql(whereClause = Some("game_id = ?"), orderBy = Some("sequence"))
    override val values = Seq(id)
    override def reduce(rows: Iterator[RowData]) = rows.map(fromRow).toList
  }

  case class RemoveGameMovesByGame(gameId: UUID) extends Statement {
    override val sql = s"delete from $tableName where game_id = ?"
    override val values = Seq(gameId)
  }

  override protected def fromRow(row: RowData) = {
    val gameId = row("game_id") match { case s: String => UUID.fromString(s) }
    val sequence = row("sequence") match { case i: Int => i }
    val playerId = row("player_id") match { case s: String => UUID.fromString(s) }
    val moveType = row("move") match { case s: String => s }
    val cards = row("cards") match { case a: Array[UUID] => a; case x => throw new IllegalArgumentException(x.getClass.getName) }
    val src = row("src") match { case s: String => Some(s) }
    val tgt = row("tgt") match { case s: String => Some(s) }
    val occurred = row("occurred") match { case ldt: LocalDateTime => ldt }
    GameHistory.Move(gameId, sequence, playerId, moveType, Some(cards), src, tgt, occurred)
  }

  protected def toDataSeq(m: GameHistory.Move) = {
    Seq[Any](m.gameId, m.sequence, m.playerId, m.moveType, m.cards.toArray, m.src, m.tgt, DateUtils.toSqlTimestamp(m.occurred))
  }
}