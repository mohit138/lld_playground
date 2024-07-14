package org.battleship.game.Service.TargetStrategy;

import org.battleship.game.Model.BattleShipGame;
import org.battleship.game.Model.Coordinate;

public interface TargetStrategyInterface {
    public Coordinate getValidTargetCoordinate(BattleShipGame game);
}
