package com.home.jblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
//	AuthenticationManager authenticationManager;
//	public AuthorizationServerConfigurer(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
//	}
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//		endpoints.authenticationManager(authenticationManager);
//	}
	
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired(required = true)
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("iamclient")
		.secret(passwordEncoder.encode("iamsecret"))
		.authorizedGrantTypes("authorization_code", "password", "refresh_token")
		.scopes("read", "write")
		.accessTokenValiditySeconds(60*60)
		.refreshTokenValiditySeconds(6*60*60)
		.autoApprove(true);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}
}



//public class OAuth2Config extends AuthorizationServerConfigurerAdapter  {
//    @Autowired
//    PasswordEncoder encoder;
//    @Autowired
//    @Qualifier("primaryDataSource")
//    DataSource primaryDatasource;
//    @Autowired
//    CustomDetailService userDetailsService;
//    private String clinetId = "TctTest";
//    private String clientSeceret = "12341234aa";
//    private String privateKey = "";
//    private String publicKey = "";
//    private int tokenValidSec = 20000;
//    private int refreshTokenValidSec = 20000;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Bean
//    public JwtAccessTokenConverter tokenEnhancerJwt() {
//        Resource privateKeyRes = new ClassPathResource("key/privateKey.txt");
//        Resource publicKeyRes = new ClassPathResource("key/publicKey.txt");
//        try {
//            this.privateKey = new String(IOUtils.toByteArray(privateKeyRes.getInputStream()));
//            this.publicKey = new String(IOUtils.toByteArray(publicKeyRes.getInputStream()));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(privateKey);
//        converter.setVerifierKey(publicKey);
//        return converter;
//    }
//    @Bean
//    public TokenEnhancer tokenEnhancer() {
//        return new CustomDefaultTokenEnhancer();
//    }
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        // TODO Auto-generated method stub
//        //super.configure(security);
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // TODO Auto-generated method stub
//        //super.configure(clients);
//        System.out.println("passsssssssssssssssssssssssssssssssssss");
//        System.out.println(encoder.encode(clientSeceret));
//        clients.jdbc(primaryDatasource)
//        .withClient("sampleClinetId")
//        .authorizedGrantTypes("implicit")
//        .scopes("read","write")
//        .autoApprove(true)
//        .redirectUris("https://daum.net") <https://daum.net>
//        .and()
//        .withClient(clinetId)
//        .secret(encoder.encode(clientSeceret))
//        .authorizedGrantTypes(
//            "password","authorization_code","refresh_token")
//        .scopes("read","write");
//    }
//// jwt 말고 deault 토큰
////        @Override
////        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////                // TODO Auto-generated method stub
////                //super.configure(endpoints);
////                endpoints
////                .authenticationManager(authenticationManager)
////                .tokenStore(tokenStore())
////                .accessTokenConverter(new DefaultAccessTokenConverter())
////                .userDetailsService(userDetailsService)
////                .tokenEnhancer(tokenEnhancer());
////        }
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {