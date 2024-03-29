# Project plan:

## Introduzione:
Il presente piano di progetto delinea il quadro strategico e operativo per lo sviluppo di un software di gestione economica aziendale, concepito e realizzato da un team di tre studenti di ingegneria informatica: 
* Lorenzo Colombo (1081134) 
* Carlo Alberto Poggiu (1079843) 
* Gabriele Merli (1081373)  

Il progetto è un sistema gestionale avanzato progettato per ottimizzare l'organizzazione e la gestione dei cantieri. Questo strumento versatile consente una gestione efficiente del personale, del materiale e delle attrezzature, garantendo il massimo controllo e la massima efficienza in ogni fase del progetto.


## Modello di processo

### Modello Incrementale:
**Caratteristiche Principali:** Lo sviluppo incrementale prevede la suddivisione del progetto in parti più piccole, chiamate incrementi, ciascuno dei quali implementa e rilascia una porzione specifica delle funzionalità richieste. Ogni incremento aggiunge nuove funzionalità o migliora quelle esistenti. Questo modello consente di rilasciare parti del software più rapidamente, consentendo un feedback tempestivo dagli utenti e facilitando adattamenti in corso d'opera. 

## Organizzazione del progetto
Abbiamo strutturando il nostro lavoro attraverso dei meeting online/presenza in modo da tracciare una linea generale sui task da eseguire. 
La documentazione riguarda sia la fase iniziale, centrale e finale del progetto. Per la fase di sviluppo abbiamo usato i vari diagrammi messi a disposizione da UML,per poi partire con l’implementazione dell’idea.
In particolare, il team si incontra costantemente per verificare il lavoro svolto dall'ultimo meet e pianificare i passaggi successivi.

## Standard e Linee Guida
Il progetto è stato sviluppato utilizzando Java su Eclipse. Abbiamo seguito le convenzioni standard di codifica Java, che includono l'uso di una nomenclatura appropriata per classi, metodi e variabili. Per la gestione delle dipendenze del progetto, è stato adottato Maven.

Per la realizzazione dell'interfaccia grafica utente (GUI), è stato utilizzato NetBeans. Infine, la creazione e la manutenzione del database e delle sue tabelle sono state realizzate utilizzando  DB Browser (SQLite).

### Standard,linee guida e procedure
Alla fine di ogni sprint bisogna creare un report in cui specificare gli obiettivi portati a termine, decisi all'interno dello sprint backlog.

## Attività di gestione
Abbiamo usato il paradigma Capo squadra programmatore in cui:
* Programmatore: Gabriele Merli
* Co-Programmatore e Aiuto Documentazione: Lorenzo Colombo
* Design e Documentazione: Poggiu Carlo Alberto    

## Rischi:
Nel nostro caso il principale rischio è la gestione grafica e del codice per lo sviluppo dell’idea.
Il tutto però viene risolto con l’ausilio di strumenti aggiuntivi e con l’unione delle competenze maturate durante l’anno accademico.
Un altro rischio per la gestione errata riguarda il database e la struttura di quest'ultimo che deve rispettare determinati vincoli e regole da non dimenticare durante l'implementazione.

## Personale:
Utilizzando una modalità di sviluppo SWAT che ci permette di coordinare il lavoro in modo intelligente e graduale.

## Metodi e tecniche:
Le tecniche che usiamo per la rappresentazione logica del progetto sono date dai seguenti diagrammi UML: 
* Diagramma casi di uso (per l'ingegneria dei requisiti) 
* Diagramma delle classi (per la fase di progettazione, a scopo indicativo, impossibile rappresentarlo con 100% di accuratezza rispetto al codice)  
* Diagramma di stato 
* Diagramma di attività 
* Diagramma di componenti (?)
Per la fase di implementazione e di test utilizziamo Java e jUnit

## Garanzie di qualità
Per mantenere l'integrità del nostro codice, adottiamo strumenti collaborativi come GitHub e applichiamo le competenze tecniche acquisite durante l'anno accademico per assicurare la conformità del software. 
* ***Must*** have: Interfaccia grafica e funzioni gestionali
* **Should** have: Elenco fatture, possibilità di esportare i file in excel/txt
* *Could* have: Mezzi utilizzati per i lavori, certificato lavoratori
  
## Pacchetti di lavoro
I ruoli sono divisi equamente sulla base della complessità del progetto
* Gabriele Merli: Si occuperà della programmazione delle parti fondamentali dell'idea
* Lorenzo Colombo: Si occuperà anche lui della programmazione del software, correzioni grafiche e gestione del database, curando anche i diagrammi UML per permettere una visione a 360° del progetto
* Carlo Alberto Poggiu: Si occuperà anche lui della programmazione e delineamento del database con mansione principale puntata sulla produzione della documentazione.

## Risorse
Le tecnologie utilizzate sono: 
* Java con le relative librerie aggiuntive 
* GitHub per il lavoro condiviso
* Canva UI/UX design
* DB Browser (SQLite)

## Cambiamenti
I cambiamenti verranno gestiti tramite gli incontri settimanali fissati per discutere il progetto per poi in caso positivo apportare le modifiche su GitHub.
E' stato deciso di lasciare a successive implementazioni la possibilità di scaricare le fatture su desktop come opzionale.

## Consegna
Si prevede di consegnare il progetto per fine Gennaio con la possibilità di apportare delle lievi modifiche fino al 15 di Febbraio
