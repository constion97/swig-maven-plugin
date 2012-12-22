package org.apache.maven.plugin.swig;

import java.util.List;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.plugin.BuildPluginManager;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;

@Component( role = AbstractMavenLifecycleParticipant.class, hint = "swig" )
public class SwigMavenExtension extends AbstractMavenLifecycleParticipant
{
  @Requirement
  private Logger logger;
  
  @Override
  public void afterProjectsRead( MavenSession session ) {
    logger.info( " __  __" );
    logger.info( "|  \\/  |__ _Apache__ ___" );
    logger.info( "" );
    List<Plugin> ps = session.getCurrentProject().getBuildPlugins();
    for (Plugin p : ps) {
      if ("swig-maven-plugin".equals(p.getArtifactId())) {
        logger.info("swigConfig33 :" + p.getConfiguration());
        for(PluginExecution pe : p.getExecutions()) {
          logger.info("swigConfig33-2 :" + pe.getConfiguration());
        }
      } else if ("maven-nar-plugin".equals(p.getArtifactId())) {
        logger.info("narConfig33 :" + p.getConfiguration());
        for(PluginExecution pe : p.getExecutions()) {
          logger.info("narConfig33-2 :" + pe.getConfiguration());
        }
      }
    }
  }
}
