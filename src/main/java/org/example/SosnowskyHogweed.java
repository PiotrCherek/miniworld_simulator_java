package org.example;

public class SosnowskyHogweed extends Plant {
    private static final int SOSNOWSKY_HOGWEED_STRENGTH = 10;
    private static final char SOSNOWSKY_HOGWEED_CHAR = 'B';

    public SosnowskyHogweed(World world, int x, int y) {
        super(world, x, y);
        setStrength(SOSNOWSKY_HOGWEED_STRENGTH);
    }

    @Override
    public void action(World world) {
        int x = getX();
        int y = getY();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                Organism[] opponent = new Organism[1];
                if (world.worldPositionValid(x + dx, y + dy)) {
                    world.findOpponent(x + dx, y + dy, opponent, this);
                    if (opponent[0] != null && opponent[0] instanceof Animal) {
                        world.organismKilled(opponent[0]);
                        Report report = world.getReportPTR();
                        report.fightReport(getOrganismName(), opponent[0].getOrganismName());
                    }
                }
            }
        }
        super.action(world);
    }

    @Override
    public char draw() {
        return SOSNOWSKY_HOGWEED_CHAR;
    }
}
