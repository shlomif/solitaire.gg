package models.rules.impl

import models.rules._

object SuperChallengeFreeCell extends GameRules(
  id = "superchallengefreecell",
  completed = false,
  title = "Super Challenge FreeCell",
  like = Some("challengefreecell"),
  links = Seq(
    Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/super_challenge_freecell.htm"),
    Link("Michael Keller's amazing FreeCell FAQ", "solitairelaboratory.com/fcfaq.html#AceDepth")
  ),
  layout = "f|c|t",
  foundations = Seq(FoundationRules(numPiles = 4, autoMoveCards = true)),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.HighRank,
      pilesWithLowCardsAtBottom = 8
    )
  ),
  cells = Some(CellRules())
)
