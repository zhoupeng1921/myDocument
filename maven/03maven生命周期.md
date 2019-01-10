# 生命周期

maven强大的一个原因是它有一个十分完善的生命周期模型，这个生命周期可以从两个方面来解释。1. 运行maven的每个步骤由它定义的，这种预定义的默认行为使得我们使用maven变得简单。2. 这个模型是一种标准，在不同的项目中，使用maven的接口是一样的。

maven有`三套` `相互独立`的生命周期:

- Clean Lifecycle 在进行真正构建之前的一些清理工作
- Default Lifecycle 构建的核心部分，编译、测试、打包、部署等
- Site Lifecycle 生成项目报告、站点、发布站点

Maven定义了三套生命周期：clean、default、site，每个生命周期都包含了一些阶段（phase）。三套生命周期相互独立，但各个生命周期中的phase却是有顺序的，且后面的phase依赖于前面的phase。执行某个phase时，其前面的phase会依顺序执行，但不会触发另外两套生命周期中的任何phase

每套生命周期都是由一组阶段组成：

clean生命周期包含三个阶段：

- pre-clean  执行需要在clean之前完成的工作
- clean 移除上一次构建生成的文件
- post-clean 执行一些需要在clean之后立刻要完成的工作

site生命周期阶段：

- pre-site  执行一些需要在生成站点文档之前完成的工作
- site 生成项目的站点文档
- post-site 执行一些需要在生成站点文档之后完成的工作，并且为部署做准备
- site-deploy 将生成的站点文档部署到特定的服务器上

default生命周期：

- validate
- generate-sources
- process-sources
- generate-resources
- process-resources          复制并处理资源文件，至目标目录，准备打包。
- compile          编译项目的源代码。
- process-classes
- generate-test-sources  
- process-test-sources 
- generate-test-resources
- process-test-resources          复制并处理资源文件，至目标测试目录。
- test-compile          编译测试源代码。
- process-test-classes 
- test          使用合适的单元测试框架运行测试。这些测试代码不会被打包或部署。
- prepare-package 
- package          接受编译好的代码，打包成可发布的格式，如 JAR 。
- pre-integration-test
- integration-test
- post-integration-test 
- verify 
- install          将包安装至本地仓库，以让其它项目依赖。
- deploy          将最终的包复制到远程的仓库，以让其它开发人员与项目共享。

在每个生命周期中，运行某个命令，它之前的所有阶段也会执行