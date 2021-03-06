package de.alpharogroup.jetty9.runner.factories;

import org.eclipse.jetty.deploy.DeploymentManager;
import org.eclipse.jetty.deploy.PropertiesConfigurationManager;
import org.eclipse.jetty.deploy.providers.WebAppProvider;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * A factory for creating DeploymentManager objects.
 */
public class DeploymentManagerFactory
{

	/**
	 * New deployment manager.
	 *
	 * @param contexts
	 *            the contexts
	 * @param monitoredDirName
	 *            the monitored dir name
	 * @param defaultsDescriptor
	 *            the defaults descriptor
	 * @return the deployment manager
	 */
	// see:http://git.eclipse.org/c/jetty/org.eclipse.jetty.project.git/tree/examples/embedded/src/main/java/org/eclipse/jetty/embedded/LikeJettyXml.java
	public static DeploymentManager newDeploymentManager(final ContextHandlerCollection contexts,
		final String monitoredDirName, final String defaultsDescriptor)
	{
		final DeploymentManager deployer = new DeploymentManager();
		deployer.setContexts(contexts);
		deployer.setContextAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
			".*/servlet-api-[^/]*\\.jar$");
		final WebAppProvider webAppProvider = new WebAppProvider();
		webAppProvider.setMonitoredDirName(monitoredDirName);
		if (defaultsDescriptor != null)
		{
			webAppProvider.setDefaultsDescriptor(defaultsDescriptor);
		}
		webAppProvider.setScanInterval(1);
		webAppProvider.setExtractWars(true);
		webAppProvider.setConfigurationManager(new PropertiesConfigurationManager());

		deployer.addAppProvider(webAppProvider);
		return deployer;
	}
}
