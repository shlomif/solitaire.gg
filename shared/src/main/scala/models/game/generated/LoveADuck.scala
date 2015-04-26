// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

// scalastyle:off
object LoveADuck extends GameRules(
  id = "loveaduck",
  title = "Love a Duck",
  description = "A ^yukon^-type game, played on an interlocking tableau.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  pyramids = Seq(
    PyramidRules(
      name = "Tableau",
      suitMatchRuleForBuilding = SuitMatchRule.AlternatingColors,
      rankMatchRuleForBuilding = RankMatchRule.Down,
      suitMatchRuleForMovingStacks = SuitMatchRule.Any,
      rankMatchRuleForMovingStacks = RankMatchRule.Any,
      mayMoveToNonEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      mayMoveToEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      emptyFilledWith = PyramidFillEmptyWith.Kings
    )
  ),
  complete = false
)
// scalastyle:on

