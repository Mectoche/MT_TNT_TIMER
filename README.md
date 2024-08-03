<p align="center">
<a href="https://github.com/Mectoche/MT_TNT_TIMER"><img src="https://i.ibb.co/P41ZcjK/tnt-timer-mectoche.png" alt="watching" border="0"></a>
</p>

#                   MECTOCHE TNT TIMER
- Plugin para **servidores** de Minecraft Java Edition
# Sobre
- O **MT_TNT_TIMER** foi criado por mim, [Mectocheh](https://github.com/Mectoche), utilizando a [Bukkit-API](https://dev.bukkit.org/). Inicialmente, foi desenvolvido apenas para gravar um speedcoding no YouTube, mas infelizmente o vídeo foi privado.

# Funcionalidades
- Este plugin é multi-funcional e pode ser utilizado em qualquer servidor de Minecraft nas seguintes versões:

#
| Version |    Support    |
|---------| ------------- |
| 1.20.x  |    Active     |
| 1.19.x  |    Legacy     |

# Instalação
- Para instalar o plugin, basta copiar o arquivo [.jar](https://github.com/Mectoche/MT_TNT_TIMER/tree/main/build/libs) para a pasta plugins do seu servidor de Minecraft e reiniciar o servidor.

# Código
- Se você quiser visualizar o código-fonte do plugin, pode encontrá-lo no meu repositório no GitHub.
```java
private void tntExplode(TNTPrimed tnt) {
        Location location = tnt.getLocation();
        tnt.remove();
        location.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 4f, false, true);
    }
```



#
- _**Duvidas? Entre em contato comigo!**_
