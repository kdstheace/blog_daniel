package com.danielsoo.study.javaFundamental;

public class JavaDocStudy {


    /**
     *
     * @param anyParameter  put any string array as a parameter
     * @return return the length of given string array
     * @throws Exception
     */
    public int sampleMethod(String ... anyParameter) throws Exception{
        try{
            if(anyParameter != null){
                return anyParameter.length;
            }else{
                throw new Exception("parameter is null");
            }
        }catch (Exception e){
            e.getMessage();
            throw e;
        }
    }
}
