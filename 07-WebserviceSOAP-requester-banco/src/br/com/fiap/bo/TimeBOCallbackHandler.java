
/**
 * TimeBOCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package br.com.fiap.bo;

    /**
     *  TimeBOCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TimeBOCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TimeBOCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TimeBOCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for pesquisar method
            * override this method for handling normal response from pesquisar operation
            */
           public void receiveResultpesquisar(
                    br.com.fiap.bo.TimeBOStub.PesquisarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pesquisar operation
           */
            public void receiveErrorpesquisar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cadastrar method
            * override this method for handling normal response from cadastrar operation
            */
           public void receiveResultcadastrar(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cadastrar operation
           */
            public void receiveErrorcadastrar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for alterar method
            * override this method for handling normal response from alterar operation
            */
           public void receiveResultalterar(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from alterar operation
           */
            public void receiveErroralterar(java.lang.Exception e) {
            }
                


    }
    