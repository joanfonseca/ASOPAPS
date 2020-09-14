package com.asopaps.asopaps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
 * Clase que se encarga de configurar el servidor de recursos
 * 
 * @author Gabriel Huertas
 * 
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	
//	@Value("${server.address}")
//	private String hostAddress;
//	@Value("${server.port}")
//	private String port;
	/**
	 * Este método maneja el acceso a los endpoints para el acceso a los recursos (gestionados por el Servidor de Recursos)
	 * 
	 * Esta configuración de http establece que para las rutas explícitamente especificadas abajo se requiera de autenticación
	 * y se de acceso a las demás rutas
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers(
//					"/authenticationAdmin/{email}/{password}",
//					"/authenticationMember/{email}/{password}"
//					"/addRemoveVideoToFavorites/{idVideo:\\w+}/{idUser:\\d+}",
//					"/getUserNotifications/{idUser:\\d+}",
//					"/getViewedUserNotifications/{idUser:\\d+}",
//					"/sendResponseNotification",
//					"/setNotificationViewed/{viewedNotification:\\d+}",
//					"/addRemoveDiscussionToFavorites/{idDiscusion:\\d+}/{idUser:\\d+}",
//					"/reportDiscussion/{idDiscussion:\\d+}/{idUser:\\d+}",
//					"/reportUser/{idUserReported:\\d+}/{idUser:\\d+}",
//					"/reportComment/{idComment:\\d+}/{idUser:\\d+}",
//					"/removeDiscussion/{idDiscussion:\\d+}",
//					"/open/{idDiscission:\\d+}",
//					"/closeDiscussion/{idDiscission:\\d+}",
//					"/forumComment/{idDiscussion:\\d+}",
//					"/voteUp/{idComment:\\d+}/{idUser}",
//					"/voteDown/{idComment:\\d+}/{idUser:\\d+}",
//					"/addRemoveCommentToFavorites/{idComment:\\d+}/{idUser:d\\+}",
//					"/registerView/{idUser:\\d+}/{idDiscussion:\\d+}"
					).authenticated()
			.anyRequest().permitAll()
		.and()
		.cors()
			.configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);    
	    return firewall;
	}
	
	/**
	 * Método que genera un Bean que permite soporte para CORS desde el origen de la aplicación angular
	 * 
	 * La configuración expuesta abajo especifica como origen la URL de la aplicación angular, permite los métodos
	 * HTTP comunes (GET, POST, PUT, DELETE) y OPTIONS (debido a que OAuth2, para autenticación a veces lo requiere),
	 * los headers para el tipo de contenido y para autorización
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(
				Arrays.asList("*"
//				"http://localhost:4200",
//				"http://3.14.74.92",
//				"http://localhost:8200",
//				"http://localhost:8100"
						)
				);
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		
		//Aplica la configuración de CORS para todas las rutas
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
	
	/**
	 * Método que crea un Bean que tiene la precedencia más alta al momento del manejo de peticiones para que no tenga
	 * conflicto con otros filtros
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<CorsFilter> cors(){
		FilterRegistrationBean<CorsFilter> corsFilterBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		corsFilterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return corsFilterBean;
	}
}