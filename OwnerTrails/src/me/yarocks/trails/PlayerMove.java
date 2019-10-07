package me.yarocks.trails;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * Created by USER on 7/28/2014.
 */
public class PlayerMove implements Listener {
    @EventHandler
    public void onPlayerJoin(final PlayerMoveEvent e) {
        Player p = e.getPlayer();

            if (OwnerTrails.trails.contains(p.getName())) {

                Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);

                FireworkMeta fm = f.getFireworkMeta();
                fm.addEffect(FireworkEffect.builder()
                        .flicker(false)
                        .trail(true)
                        .with(FireworkEffect.Type.STAR)
                        .withColor(Color.GREEN)
                        .withFade(Color.BLUE)
                        .build());
                fm.setPower(3);
                f.setFireworkMeta(fm);

            }
            else{
                return;
        }

        }
    }



