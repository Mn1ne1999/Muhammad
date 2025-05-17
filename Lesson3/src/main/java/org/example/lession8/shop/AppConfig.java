package org.example.lession8.shop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration                // «В этом классе — настройки Spring»
@ComponentScan("org.example.lession8.shop")   // искать все @Component/@Service/...
public class AppConfig {}
