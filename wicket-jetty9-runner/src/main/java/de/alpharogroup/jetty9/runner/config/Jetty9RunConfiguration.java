package de.alpharogroup.jetty9.runner.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.eclipse.jetty.deploy.DeploymentManager;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jetty9RunConfiguration
{

	ServletContextHandler servletContextHandler;
	int httpPort;
	int httpsPort;
	String keyStorePathResource;
	String keyStorePassword;
	HandlerCollection handlers;
	ContextHandlerCollection contexts;
	DeploymentManager deployer;
}
