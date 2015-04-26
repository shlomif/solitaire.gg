// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object TreviGarden extends GameRules(
  id = "trevigarden",
  title = "Trevi Garden",
  description = "A variation of ^stonewall^ made easier by the addition of two cells.",
  waste = Some(
    WasteRules(
      name = "Fountain"
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      name = "Garden",
      numPiles = 6,
      initialCards = InitialCards.Count(6),
      cardsFaceDown = TableauFaceDownCards.OddNumbered,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  cells = Some(
    CellRules(

      numPiles = 2,
      initialCards = 2
    )
  ),
  complete = false
)
// scalastyle:on

