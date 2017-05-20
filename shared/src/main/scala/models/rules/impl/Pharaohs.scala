package models.rules.impl

import models.rules._

object Pharaohs extends GameRules(
  id = "pharaohs",
  completed = false,
  title = "Pharaohs",
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/pharaohs.htm"),
    Link("Rapture Technologies KingSol", "www.rapturetech.com/KingSol/Rules/Pharaohs.htm")
  ),
  layout = "f|ppp",
  victoryCondition = VictoryCondition.NoneInPyramid,
  cardRemovalMethod = CardRemovalMethod.RemovePairsAddingToThirteenOrK,
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      canMoveFrom = FoundationCanMoveFrom.Never,
      visible = false,
      autoMoveCards = true
    )
  ),
  pyramids = Seq(
    PyramidRules(
      rankMatchRuleForBuilding = RankMatchRule.Down,
      rankMatchRuleForMovingStacks = RankMatchRule.Down,
      mayMoveToNonEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      mayMoveToEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation")
    ),
    PyramidRules(
      setNumber = 1,
      height = 6,
      rankMatchRuleForBuilding = RankMatchRule.Down,
      rankMatchRuleForMovingStacks = RankMatchRule.Down,
      mayMoveToNonEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      mayMoveToEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation")
    ),
    PyramidRules(
      setNumber = 2,
      height = 2,
      rankMatchRuleForBuilding = RankMatchRule.Down,
      rankMatchRuleForMovingStacks = RankMatchRule.Down,
      mayMoveToNonEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation"),
      mayMoveToEmptyFrom = Seq("Waste", "Tableau", "Pyramid", "Foundation")
    )
  )
)
