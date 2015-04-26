// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object AgnesSorel extends GameRules(
  id = "agnessorel",
  title = "Agnes Sorel",
  description = "A variation on ^klondike^ where cards are dealt directly onto the tableau as in ^spider^.",
  deckOptions = DeckOptions(
    lowRank = Some(Rank.Unknown)
  ),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.Tableau,
      maximumDeals = Some(1)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      initialCards = InitialCards.Count(1),
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameColor,
      suitMatchRuleForMovingStacks = SuitMatchRule.SameColor,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)
// scalastyle:on

