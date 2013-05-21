package com.github.games647.scoreboardstats.listener;

import com.github.games647.scoreboardstats.pvpstats.Database;
import com.github.games647.scoreboardstats.pvpstats.PlayerCache;
import com.github.games647.variables.VariableList;
import de.blablubbabc.insigns.Changer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class SignsListener {

    public static void registerSigns(final de.blablubbabc.insigns.InSigns instance) {

        instance.addChanger(new Changer(VariableList.SIGN_KILL, VariableList.SIGN_PERMISSION) {
            @Override
            public String getValue(final Player player, final Location lctn) {
                final PlayerCache playercache = Database.getCache(player.getName());

                return playercache == null ? "" : String.valueOf(playercache.getKills());
            }
        });

        instance.addChanger(new Changer(VariableList.SIGN_DEATH, VariableList.SIGN_PERMISSION) {
            @Override
            public String getValue(final Player player, final Location lctn) {
                final PlayerCache playercache = Database.getCache(player.getName());

                return playercache == null ? "" : String.valueOf(playercache.getDeaths());
            }
        });

        instance.addChanger(new Changer(VariableList.SIGN_MOB, VariableList.SIGN_PERMISSION) {
            @Override
            public String getValue(final Player player, final Location lctn) {
                final PlayerCache playercache = Database.getCache(player.getName());

                return playercache == null ? "" : String.valueOf(playercache.getMob());
            }
        });

        instance.addChanger(new Changer(VariableList.SIGN_KDR, VariableList.SIGN_PERMISSION) {
            @Override
            public String getValue(final Player player, final Location lctn) {
                return Database.getCache(player.getName()) == null ? "" : String.valueOf(Database.getKdr(player.getName()));
            }
        });

        instance.addChanger(new Changer(VariableList.SIGN_STREAK, VariableList.SIGN_PERMISSION) {
            @Override
            public String getValue(final Player player, final Location lctn) {
                final PlayerCache playercache = Database.getCache(player.getName());

                return playercache == null ? "" : String.valueOf(playercache.getStreak());
            }
        });
    }
}
