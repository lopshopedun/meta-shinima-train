# Yocto custom layer for Shinima-train project

### Description

"Shinima-train" is project for chinese high speed railways where train's radio relays are switching between ground stations located on towers along the way of the train.

The word "Shinima" is taken from the Internet meme "Shinima Hue Nyong" to emphasize the originality and my attitude to this project, and also that the name "china*-train*" has already been used several times in local discussions.

This layer provides custom recipes of debug/release libraries and packages for the project "Shinima-train". These recipes are collected in packagegroups that are added to debug and release images. 

In other words, this layer is created to customize the default image from the Axiomtek vendor through packagegroups, as recommended in [Yocto Project Development Manual](https://www.yoctoproject.org/docs/1.8.1/dev-manual/dev-manual.html#usingpoky-extend-customimage-customtasks).

See [packagegroups](recipes-core/packagegroups) for reference.

The images `axl-shnm-debug-image` and `axl-shnm-release-image` are associated with debug and release packagegroups, respectively.


### Setup Yocto environment from scratch

First, read the [Yocto Project Reference Manual](https://www.yoctoproject.org/docs/1.8.1/ref-manual/ref-manual.html) for understanding what is going on.

The manual is partially taken from [IFB125 Linux User Manual](http://www.axiomtek.com/Download/download/IFB125/IFB125%20Linux%20User's%20Manual%20VA2_12-20-2018.pdf) and supplemented with my experience.

It was tested in Ubuntu 16.04 x86_64.

At first it requires install needed packages:

```
user@host:~$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python-progressbar patch m4 diffstat bison
```

Then repeat steps from the manual:

```
user@host:~$ mkdir ifb && cd ifb
user@host:~/ifb$ mkdir bin
user@host:~/ifb$ sudo curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ./bin/repo
user@host:~/ifb$ mkdir fsl-community-bsp && cd fsl-community-bsp
user@host:~/ifb/fsl-community-bsp$  python ../bin/repo init -u git://git.freescale.com/imx/fsl-arm-yocto-bsp.git -b imx-3.14.52-1.1.0_ga
...
user@host:~/ifb/fsl-community-bsp$ python ../bin/repo sync
...
user@host:~/ifb/fsl-community-bsp$ cp -v /path/to/IFB125-Linux-bsp-V1.0.3/bla/bla/meta-axiomtek ./sources
...
user@host:~/ifb/fsl-community-bsp$ echo -e "\${BSPDIR}/sources/meta-axiomtek \\n\${BSPDIR}/sources/meta-shinima-train \\n" >> ./sources/base/conf/bblayers.conf
```

Run following command to setup build environment, and it will move you to `/build` folder:

```
user@host:~/ifb/fsl-community-bsp$ DISTRO=poky MACHINE=rsb101 EULA=1 source fsl-setup-release.sh -b build
```

Comment out a line `"INHERIT += "sanity"` in ./sources/poky/meta/conf/sanity.conf. 

Also comment out lines containing unnecessary `meta-browser`, `meta-gnome`, `meta-ruby`, `meta-qt5` layers in ./sources/fsl-community-bsp.sh.

Between reboots if you want build image or recipes again, always run command

```
user@host:~/ifb/fsl-community-bsp$ DISTRO=poky MACHINE=rsb101 EULA=1 source fsl-setup-release.sh -b build
```

Before building the image, check which layers will be built and, if there were unnecessary ones, comment out manually their `<layer>/conf/layer.conf`

```
user@host:~/ifb/fsl-community-bsp/build$ bitbake-layers show-layers
```

Finally, now you can build `axl-shnm-debug-image` or `axl-shnm-release-image` image:

```
user@host:~/ifb/fsl-community-bsp/build$ bitbake axl-shnm-debug-image
```

### TO-DO
* Replace `timeout` busybox utility with `timeout` from coreutils 

### Mantainer(s)

Dmitry Trefilov <d.trefilov@dokltd.ru>, <vmp.2012@ya.ru>
