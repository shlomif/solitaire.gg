package game

import help.HelpService
import org.scalajs.jquery.{jQuery => $}
import utils.TemplateUtils

object GameListService {
  private[this] var initialized = false

  def update(ag: Option[ActiveGame], onNewGame: Seq[String] => Unit) = {
    val panel = $("#panel-list-games .content")

    if (!initialized) {
      panel.html(GameListTemplate.panelContent().toString)

      TemplateUtils.clickHandler($(".rules-link", panel), jq => onNewGame(Seq(jq.data("rules").toString)))
      TemplateUtils.clickHandler($(".help-link", panel), jq => HelpService.show(Some(jq.data("rules").toString)))

      initialized = true
    }

    val optionsEl = $(".options-el", panel)

    ag match {
      case Some(activeGame) => optionsEl.html(GameListTemplate.optionsContent(activeGame).toString)
      case None => optionsEl.html($("#home-content").html())
    }
  }
}
