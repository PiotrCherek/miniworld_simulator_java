package org.example;

public class SowThistle extends Plant {
    private static final int SOW_THISTLE_STRENGTH = 0;
    private static final char SOW_THISTLE_CHAR = 'M';
    private static final int SOW_THISTLE_SPREAD_ATTEMPTS = 3;

    public SowThistle(World world, int x, int y) {
        super(world, x, y);
        setStrength(SOW_THISTLE_STRENGTH);
    }

    @Override
    public void action(World world) {
        for (int i = 0; i < SOW_THISTLE_SPREAD_ATTEMPTS; i++) {
            super.action(world);
        }
        setAge(getAge() - 2);
    }

    @Override
    public char draw() {
        return SOW_THISTLE_CHAR;
    }
}
