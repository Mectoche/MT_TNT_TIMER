# _MECTOCHE TNT TIMER_
- ***Plugin for **servers** of Minecraft Java Edition***
# _About_
- _The **MT_TNT_TIMER** was created by me, [Mectocheh](https://github.com/Mectoche), using the [Bukkit-API](https://dev.bukkit.org/). Initially, it was developed just to record speedcoding on YouTube, but unfortunately the video was made private._
  
- _Multi-functional and can be used on any Minecraft server in the following versions:_

  
<div class ="version" align="center">

| Version |    Support    |
|---------| ------------- |
| 1.20.x  |    Active     |
| 1.19.x  |    Legacy     |

</div>

# _Code_
```java
private void tntExplode(TNTPrimed tnt) {
        Location location = tnt.getLocation();
        tnt.remove();
        location.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 4f, false, true);
    }
```



#
- _**Doubts? Contact me!**_
<p align="center">
<a href="https://github.com/Mectoche/MT_TNT_TIMER"><img src="https://i.ibb.co/P41ZcjK/tnt-timer-mectoche.png" alt="watching" border="0"></a>
</p>
