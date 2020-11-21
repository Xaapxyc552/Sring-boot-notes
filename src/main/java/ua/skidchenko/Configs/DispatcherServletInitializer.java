//package ua.skidchenko.Configs;
//
//import ua.skidchenko.DAOLayer.Config.DataSourceConfig;
//import ua.skidchenko.DAOLayer.Config.HibernateConfig;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//
//public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
////        LoggerContext context = (LoggerContext) LogManager.getContext(false);
////        context.setConfigLocation(URI.create("resources/log4j2"));
////        context.reconfigure();
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//
//        return new Filter[] {getRussianFilter()};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String [] {("/*")};
//    }
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] {SpringConfig.class,HibernateConfig.class, DataSourceConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] {WebConfig.class};
//    }
//
//    private Filter getRussianFilter () {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        return filter;
//    }
//
//
//}
