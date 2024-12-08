package br.fateczl.carometro.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class SpringWebConfig implements ApplicationContextAware, WebMvcConfigurer{

	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
	private final TurmaConverter turmaConverter;
	private final TurmaIdConverter turmaIdConverter;
	private final HistoricoIdConverter historicoIdConverter;
	
	public SpringWebConfig(TurmaConverter turmaConverter, TurmaIdConverter turmaIdConverter, HistoricoIdConverter historicoIdConverter) {
		this.turmaConverter = turmaConverter;
		this.turmaIdConverter = turmaIdConverter;
		this.historicoIdConverter = historicoIdConverter;
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(turmaConverter);
		registry.addConverter(turmaIdConverter);
		registry.addConverter(historicoIdConverter);
	}

}
