package models.pile.actions

import models.game.GameState
import models.pile.Pile
import models.{CardsMoved, ResponseMessage}

case class SelectPileAction(id: String, f: (Pile, GameState) => Seq[ResponseMessage])

object SelectPileActions {
  val none = SelectPileAction("none", (_, _) => Nil)

  def moveAllFrom(targets: Seq[String], trigger: () => Unit) = SelectPileAction("move-all", (pile, gameState) => {
    gameState.stockCounter += 1
    targets.flatMap { target =>
      val targetPile = gameState.pilesById(target)
      val cards = Seq(targetPile.cards.reverse: _*)
      trigger()
      cards.map { card =>
        targetPile.removeCard(card)
        pile.addCard(card)
        CardsMoved(Seq(card.id), target, pile.id, turn = Some(false))
      }
    }
  })

  def moveAllNonEmpty(target: String) = SelectPileAction("move-all", (pile, gameState) => {
    val targetPile = gameState.pilesById(target)
    val cards = Seq(targetPile.cards.reverse: _*)
    cards.map { card =>
      targetPile.removeCard(card)
      pile.addCard(card)
      CardsMoved(Seq(card.id), target, pile.id, turn = Some(false))
    }
  })
}
