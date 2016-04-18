package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-04-18.
 */
public class TowersOfHanoiSolver {


    public static void solve(TowersOfHanoi game) {
        solve(game, 0, 2, 1, game.getNumDisks(0));
    }

    private static void solve(TowersOfHanoi game, int from, int to, int tmp, int numDisks) {
        if (numDisks > 0) {
            solve(game, from, tmp, to, numDisks - 1);
            game.move(from, to);
            solve(game, tmp, to, from, numDisks - 1);
        }
    }


}
