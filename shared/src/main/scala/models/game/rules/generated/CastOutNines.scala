// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

object CastOutNines extends GameRules(
  id = "castoutnines",
  title = "Cast Out Nines",
  description = "A difficult variation of ^deuces^ or ^busyaces^ where no cards are already on the foundation and there are only seven tableau pile" +
  "s. Invented by Thomas Warfield.",
  deckOptions = DeckOptions(
    numDecks = 2,
    lowRank = Rank.Nine
  ),
  stock = Some(
    StockRules(
      maximumDeals = Some(1)
    )
  ),
  waste = Some(WasteRules()),
  foundations = Seq(
    FoundationRules(
      numPiles = 8,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)
