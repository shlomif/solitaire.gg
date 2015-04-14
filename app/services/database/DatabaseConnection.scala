package services.database

import com.simple.jdub._
import play.api.Play
import utils.{ Logging, Config }
import utils.metrics.Checked

object DatabaseConnection extends Logging {
  private[this] val db = {
    val cfg = Play.current.configuration
    val url = cfg.getString("db.default.url").getOrElse(throw new IllegalArgumentException("No database url provided."))
    val username = cfg.getString("db.default.username").getOrElse(Config.projectId)
    val password = cfg.getString("db.default.password").getOrElse(Config.projectId)
    val name = Some(Config.projectId)
    val healthCheckRegistry = Some(Checked.healthCheckRegistry)
    val maxSize = 32
    val maxWait = 10000
    Database.connect(url, username, password, name, maxWait = maxWait, maxSize = maxSize, healthCheckRegistry = healthCheckRegistry)
  }

  def open() = {
    DatabaseSchema.update()
  }

  def close() = {
    db.close()
  }

  def transaction[A](f: => A) = {
    db.transactionScope(f)
  }

  def query[A](query: RawQuery[A]) = {
    log.debug("Running query [" + query.sql + "] with values [" + query.values.mkString(", ") + "].")
    db.query(query)
  }

  def execute(statement: Statement) = {
    log.debug("Executing statement [" + statement.sql + "] with values [" + statement.values.mkString(", ") + "].")
    db.execute(statement)
  }
}
