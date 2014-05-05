OSGi-Services
=============


Alle Services im OSGi angemeldet und sollen über ComponentServiceBus gesteuert werden.

Der ComponentServiceBus lässt sich nicht als Service mit Klassenzugriff einbinden, 
Error in der untersten Codezeile der Startmethode des Activators. 

Dort soll der Service des ComponentServiceBus über die Methode:

context.registerService(ComponentServiceBus.class.getName(), 
                        new ComponentServiceBus(printingSystem, messagingSystem), 
                        null);

angemeldet werden.	

Nur durch Auskommentieren dieser Methode ist ein erfolgreiches aktivieren des OSGi-Plugins
möglich.




==================================================
Nur das Messanger Projekt :  
                        de.leuphana.cosu.MessagingOSGi
ist relevant.
