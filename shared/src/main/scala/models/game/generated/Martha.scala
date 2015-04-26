// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object Martha extends GameRules(
  id = "martha",
  title = "Martha",
  description = "An easy game with no stock where half the cards start face down. Somewhat similar to ^bakersdozen^.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      initialCards = InitialCards.PileIndex,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 12,
      initialCards = InitialCards.Count(4),
      cardsFaceDown = TableauFaceDownCards.OddNumbered
    )
  ),
  complete = false
)
// scalastyle:on

