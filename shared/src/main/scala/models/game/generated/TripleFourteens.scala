// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object TripleFourteens extends GameRules(
  id = "triplefourteens",
  title = "Triple Fourteens",
  description = "An three-deck version of ^fourteenout^ which was invented by Thomas Warfield.",
  cardRemovalMethod = CardRemovalMethod.RemovePairsAddingToFourteen,
  deckOptions = DeckOptions(
    numDecks = 3
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 12,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 24,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None
    )
  ),
  complete = false
)
// scalastyle:on

