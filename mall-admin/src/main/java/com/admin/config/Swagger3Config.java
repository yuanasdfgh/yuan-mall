package com.admin.config;

/**
 * @author: Yuan
 * email: yuanasdfgh@gmail.com
 * @description:
 * @date 2022/8/14 12:10
 */

import com.common.config.BaseSwaggerConfig;
import com.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@Configuration //声明配置类
@EnableOpenApi //开启swagger支持
public class Swagger3Config extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.admin.controller")
                .title("mall后台系统")
                .description("mall后台相关接口文档")
                .contactName("yuan")
                .version("3.0")
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

//    /**
//     * Docket类是Swagger的配置类，要自定义修改Swagger的默认配置信息，我们需要覆盖该对象
//     * @return
//     */
//    @Bean
//    public Docket docket(){
//        //1.以OAS_30标准构建Docket配置类
//        return new Docket(DocumentationType.OAS_30)
//                //2.配置Swagger接口文档基本信息apiInfo
//                .apiInfo(apiInfo())
//                //3.select方法开启配置扫描接口的Builder
//                .select()
//                //4.指定要扫描/维护接口文档的包（否则就全部扫描）
//                .apis(RequestHandlerSelectors.basePackage("com.admin.controller"))
//                //5.路径过滤：该Docket-UI展示时，只展示指定路径下的接口文档(any表示都展示)
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 配置 Swagger 接口文档的基本信息
//     * @return
//     */
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                //1.接口文档标题
//                .title("SpringBoot整合Swagger")
//                //2.接口文档描述内容
//                .description("这里是SpringBoot整合Swagger的详细信息......，包括...")
//                //3.项目文档迭代版本
//                .version("9.0")
//                //4.主要联系人信息（姓名name，个人主页url，邮箱email）
//                .contact(new Contact("阿","www.baidu.com","@qq.com"))
//                //5.相关许可证信息
//                .license("The CSDN License")
//                //6.相关许可证链接
//                .licenseUrl("www.baidu.com")
//                //7.返回构建的ApiInfo对象
//                .build();
//    }
}