# mirror配置

如果只配置了repository，如果在repository的仓库中找不到jar包，则本地仓库会直接访问maven center,如果不想让本地仓库直接访问，就需要配置mirror，设置mirror后本地仓库会直接访问mirror中url的地址。

```x&#39;m&#39;l

```



<mirrorOf>xxx</mirrorOf>  一般要设置为*，否则与repository里的id对应，用,分割

配置了镜像后，当要下载依赖时，第一步：找到repository中id为xxx的配置，然后去镜像的rul里下载依赖。当镜像的url仓库里没有对应的依赖时，根据镜像私服的配置，去center中下载。

当Maven需要下载发布版或者快照版构件的时候，他会首先检查我们配置的远程仓库中的<releases>和<snapshots>元素，看该类型的构件是否可以下载，如果可以下载，就转到镜像地址去下载。所以我们配置的远程仓库中的<url>失效了，有效的是<releases>和<snapshots>元素。