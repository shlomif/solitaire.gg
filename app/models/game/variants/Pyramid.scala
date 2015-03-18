package models.game.variants

import java.util.UUID

import models.game.Rank.King
import models.game._
import models.game.pile.constraints.{DragFromConstraints, DragToConstraints, SelectCardConstraints}
import models.game.pile._

object Pyramid extends GameVariant.Description {
  override val key = "pyramid"
  override val name = "Pyramid"
  override val body = "Build the bottom pile up or down regardless of suit. Ranking of cards is not continuous: an Ace may be built only on a 2, a King only on a Queen."
}

case class Pyramid(override val gameId: UUID, override val seed: Int) extends GameVariant(gameId, seed) {
  override def description = Pyramid

  private val pileOptions = PileOptions(
    selectCardConstraint = Some(SelectCardConstraints.specificRank(King)),
    dragFromConstraint = Some(DragFromConstraints.topCardOnly),
    dragToConstraint = Some(DragToConstraints.total(13))
  )

  private val piles = List(
    new Stock("stock", 1, "waste", Some("waste")),
    new Waste("waste", PileOptions(selectCardConstraint = Some(SelectCardConstraints.never))),

    new Tableau("pile-1-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-2-1", "pile-2-2")))),

    new Tableau("pile-2-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-3-1", "pile-3-2")))),
    new Tableau("pile-2-2", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-3-2", "pile-3-3")))),

    new Tableau("pile-3-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-4-1", "pile-4-2")))),
    new Tableau("pile-3-2", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-4-2", "pile-4-3")))),
    new Tableau("pile-3-3", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-4-3", "pile-4-4")))),

    new Tableau("pile-4-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-5-1", "pile-5-2")))),
    new Tableau("pile-4-2", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-5-2", "pile-5-3")))),
    new Tableau("pile-4-3", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-5-3", "pile-5-4")))),
    new Tableau("pile-4-4", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-5-4", "pile-5-5")))),

    new Tableau("pile-5-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-6-1", "pile-6-2")))),
    new Tableau("pile-5-2", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-6-2", "pile-6-3")))),
    new Tableau("pile-5-3", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-6-3", "pile-6-4")))),
    new Tableau("pile-5-4", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-6-4", "pile-6-5")))),
    new Tableau("pile-5-5", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-6-5", "pile-6-6")))),

    new Tableau("pile-6-1", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-1", "pile-7-2")))),
    new Tableau("pile-6-2", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-2", "pile-7-3")))),
    new Tableau("pile-6-3", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-3", "pile-7-4")))),
    new Tableau("pile-6-4", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-4", "pile-7-5")))),
    new Tableau("pile-6-5", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-5", "pile-7-6")))),
    new Tableau("pile-6-6", pileOptions.copy(dragFromConstraint = Some(DragFromConstraints.pilesEmpty("pile-7-6", "pile-7-7")))),

    new Tableau("pile-7-1", pileOptions),
    new Tableau("pile-7-2", pileOptions),
    new Tableau("pile-7-3", pileOptions),
    new Tableau("pile-7-4", pileOptions),
    new Tableau("pile-7-5", pileOptions),
    new Tableau("pile-7-6", pileOptions),
    new Tableau("pile-7-7", pileOptions)
  )

  private val deck = Deck.shuffled(rng)

  private val layouts = Seq(
    Layout(
      width = 7.8,
      height = 4.3,
      piles = List(
        PileLocation("stock", 2.8, 3.1),
        PileLocation("waste", 3.9, 3.1),

        PileLocation("pile-1-1", 3.4, 0.2),

        PileLocation("pile-2-1", 2.8, 0.5),
        PileLocation("pile-2-2", 3.9, 0.5),

        PileLocation("pile-3-1", 2.3, 0.8),
        PileLocation("pile-3-2", 3.4, 0.8),
        PileLocation("pile-3-3", 4.5, 0.8),

        PileLocation("pile-4-1", 1.7, 1.1),
        PileLocation("pile-4-2", 2.8, 1.1),
        PileLocation("pile-4-3", 3.9, 1.1),
        PileLocation("pile-4-4", 5.0, 1.1),

        PileLocation("pile-5-1", 1.2, 1.4),
        PileLocation("pile-5-2", 2.3, 1.4),
        PileLocation("pile-5-3", 3.4, 1.4),
        PileLocation("pile-5-4", 4.5, 1.4),
        PileLocation("pile-5-5", 5.6, 1.4),

        PileLocation("pile-6-1", 0.6, 1.7),
        PileLocation("pile-6-2", 1.7, 1.7),
        PileLocation("pile-6-3", 2.8, 1.7),
        PileLocation("pile-6-4", 3.9, 1.7),
        PileLocation("pile-6-5", 5.0, 1.7),
        PileLocation("pile-6-6", 6.1, 1.7),

        PileLocation("pile-7-1", 0.1, 2.0),
        PileLocation("pile-7-2", 1.2, 2.0),
        PileLocation("pile-7-3", 2.3, 2.0),
        PileLocation("pile-7-4", 3.4, 2.0),
        PileLocation("pile-7-5", 4.5, 2.0),
        PileLocation("pile-7-6", 5.6, 2.0),
        PileLocation("pile-7-7", 6.7, 2.0)
      )
    )
  )

  override val gameState = GameState(gameId, description.key, seed, deck, piles, layouts)

  override def initialMoves() = {
    for(p <- gameState.piles) {
      if(p.id.startsWith("pile-")) {
        gameState.addCards(deck.getCards(1, turnFaceUp = true), p.id, reveal = true)
      }
    }
    gameState.addCards(deck.getCards(1, turnFaceUp = true), "waste", reveal = true)
    gameState.addCards(deck.getCards(), "stock")
  }

  override def isWin: Boolean = !gameState.piles.exists(p => p.id.startsWith("pile-") && p.cards.nonEmpty)
}
