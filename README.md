# Weblog-analisi-concorrente-di-un-web-log

Il log file di un web server contiene un insieme di linee, con il seguente formato: 

150.108.64.57 - - [15/Feb/2001:09:40:58 -0500] "GET / HTTP 1.0" 200 2511 in cui: 

- 150.108.64.57 indica l'host remoto, in genere secondo la dotted quad form 
- [data] 
- "HTTP request" 
- status 
- bytes sent 
- eventuale tipo del client "Mozilla/4.0......." 

L'applicazione Weblog prende in input il nome del log file e ne stampa ogni linea, in cui ogni indirizzo IP è sostituito con l'hostname.
Nel caso in cui l'indirizzo IP non sia raggiungibile la linea del file rimane invariata.

Vengono sviluppate due versioni del programma, la prima single-threaded, la seconda invece utilizza un thread pool, in cui il task assegnato ad ogni thread riguarda la traduzione di un insieme di linee del file. 

Vengono confrontati i tempi delle due versioni.
