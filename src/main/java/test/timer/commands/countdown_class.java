package test.timer.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.VersionCommand;
import org.bukkit.scheduler.BukkitRunnable;

public class countdown_class implements CommandExecutor {

    public static int count = 0;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "(エラー) : 秒数を入力してください"); //秒数が入力されていないときの処理
        } else {
            sender.sendMessage(ChatColor.GOLD + "カウントダウン" + args[0] + "秒で開始!!");

            count = Integer.parseInt(args[0]);      //コマンドから入力されるのはString型のため、int型に変換
            BukkitRunnable task = new BukkitRunnable() {

                public void run() {
                    if (count == 0) {
                        Bukkit.broadcastMessage(ChatColor.YELLOW + "TIME UP!!!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "playsound minecraft:entity.player.levelup master @a ~ ~ ~ 1 1 1");
                    } else {
                        Bukkit.broadcastMessage("残り" + count / 3600 + "時間" + (count % 3600) / 60 + "分" + (count % 60) +"秒");
                    }
                    count--;
                }
            };
        }
        return true;
    }
}
