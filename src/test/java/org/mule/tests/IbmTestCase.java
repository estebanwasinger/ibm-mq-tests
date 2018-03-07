package org.mule.tests;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.mq.jms.MQDestination;
import com.ibm.msg.client.commonservices.j2se.trace.DefaultTracer;
import com.ibm.msg.client.commonservices.provider.trace.CSPTrace;
import com.ibm.msg.client.commonservices.trace.Trace;
import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.msg.client.wmq.compat.jms.internal.JMSC;
import org.junit.Test;

public class IbmTestCase {

    @Test
    public void test() throws JMSException, IOException {
        Trace.setTraceLevel(Integer.MIN_VALUE);
        Trace.setOn(true);
        MQConnectionFactory mqConnectionFactory = new MQConnectionFactory();
        mqConnectionFactory.setHostName("0.0.0.0");
        mqConnectionFactory.setPort(1414);
//        mqConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
                //XMSC_WMQ_CONNECTION_MODE
        mqConnectionFactory.setChannel("DEV.ADMIN.SVRCONN");
        mqConnectionFactory.setQueueManager("QM1");

        //ostName="localhost" port="1414" transportType="CLIENT_MQ_TCPIP" validateConnections="true" doc:name="WMQ" password="passw0rd"
        // specification="1.1" username="admin" channel="DEV.ADMIN.SVRCONN" queueManager="QM1"

        javax.jms.Connection connection = mqConnectionFactory.createConnection("admin", "passw0rd");
        Session session = connection.createSession();

        MQDestination destination;
    }
}
