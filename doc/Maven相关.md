
### Maven模块

#### dependencyManagement,dependencies,dependency联系
```
    1. dependencyManagement > dependencies > dependency
    2. dependencyManagement一般使用在顶层pom中,用来统一管理项目中引用的版本统一.
    3. dependencyManagement 仅仅是声明的作用,也就是说此时项目还没有引入此标签中的jar
    4. dependencies 意味着项目已经导入此标签中的所有jar
    5. 如果在子pom中使用父pom中的jar引用,不用写version、scope信息,自动使用父pom中的信息.

```
