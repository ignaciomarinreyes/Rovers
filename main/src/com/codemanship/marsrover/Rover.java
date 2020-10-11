package com.codemanship.marsrover;

public class Rover {
    private int[] position;
    private String facing;

    public Rover(String facing, int x, int y) {
        this.facing = facing;
        this.position = new int[]{x, y};
    }

    public String getFacing() {
        return facing;
    }

    public int[] getPosition() {
        return position;
    }

    public void go(String instructions) {
        instructions.chars().forEach((instruction) -> {
            if (instruction == 'R') {

                if (facing.equals("N")) {
                    facing = "E";
                    return;
                }

                if (facing.equals("E")) {
                    facing = "S";
                    return;
                }

                if (facing.equals("S")) {
                    facing = "W";
                    return;
                }

                facing = "N";
            }

            if (instruction == 'L') {
                if (facing.equals("N")) {
                    facing = "W";
                    return;
                }

                if (facing.equals("W")) {
                    facing = "S";
                    return;
                }

                if (facing.equals("S")) {
                    facing = "E";
                    return;
                }

                facing = "N";
            }

            if (instruction == 'F') {
                if (facing.equals("N")) {
                    position[1] = position[1] + 1;
                }

                if (facing.equals("E")) {
                    position[0] = position[0] + 1;
                }

                if (facing.equals("S")) {
                    position[1] = position[1] - 1;
                }

                if (facing.equals("W")) {
                    position[0] = position[0] - 1;
                }
            }

            if (instruction == 'B') {
                if (facing.equals("N")) {
                    position[1] = position[1] - 1;
                }

                if (facing.equals("E")) {
                    position[0] = position[0] - 1;
                }

                if (facing.equals("S")) {
                    position[1] = position[1] + 1;
                }

                if (facing.equals("W")) {
                    position[0] = position[0] + 1;
                }
            }
        });
    }
}
