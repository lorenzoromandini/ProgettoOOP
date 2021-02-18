<h1 align="center"> Progetto Object-Oriented Programming </h1>

<h1 align="center"> Ticketmaster Europe </h1>
 
<p align="center">
La nostra applicazione permette di visualizzare gli eventi che hanno luogo in Europa, di confrontare degli elementi filtrati per parametri e per tempo al fine di stabilire quali di questi presenti il maggiore ed il minore numero di eventi, ed infine di salvare gli eventi di un paese all'interno di un file.

</p>

## **Indice dei contenuti**

* [Introduzione](#intro)
* [Diagrammi UML](#uml)
* [Avvio dell'applicazione](#avvio)
* [Rotte](#rotte)
* [Rotte Aggiuntive](#rotteaggiuntive)
* [Test](#test)
* [Documentazione](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Introduzione

Il programma TicketmasterEurope permette di studiare gli eventi che avranno luogo in Europa, utilizzando le API del sito di [Ticketmaster](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2). L'applicazione consente di ottenere le informazioni relative agli eventi che si svolgono nei paesi europei supportati da Ticketmaster, permettendo all'utente di scegliere se visualizzare la globalità degli eventi di un paese oppure raggruppare questi ultimi in base a dei parametri, quali ad esempio la tipologia, il distributore, oppure altri che verranno esaminati all'interno di questo documento.
Inoltre l'utente può effettuare dei confronti tra elementi dello stesso tipo per vedere quale di questi presenta il maggior numero di eventi all'interno di un arco temporale.
Infine è possibile salvare gli eventi di un determinato paese attraverso la scrittura di un file avente nome "{countryCode}_Total_Events", contenuto all'interno di una directory appositamente creata dalla dicitura "Total_Events".


<a name="uml"></a>
## Diagrammi UML

*Diagramma dei Casi d'Uso*

![alt text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Diagramma%20dei%20Casi%20d'Uso.jpg)

***

*Diagramma delle Classi*

![alt text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Total_ClassDiagram.jpeg)

* eu.univpm.TicketmasterEurope.controller

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Controller_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.service

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Service_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.filters

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Filters_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.stats

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Stats_ClassDiagram.jpeg)

* eu.univpm.TicketmasterEurope.saves

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Saves_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.model

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Model_ClassDiagram.jpg)

* eu.univpm.TicketmasterEurope.exception

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Exception_ClassDiagram.png)


***
*Diagramma delle Sequenze - avvio dell'applicazione*

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Sequence_start.jpg)

*Diagrammi delle Sequenze - /countryEvents & /marketEvents*

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Sequence%20_country%20%26%20marketEvents.jpg)

*Diagrammi delle Sequenze - altre rotte per ottenere gli eventi*

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Sequence_%20other%20events%20routes.jpg)

*Diagrammi delle Sequenze - /filters*

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Sequence_filter.jpg)

*Diagramma delle Sequenze - /saveEvents*

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/Sequence_stats.jpg)


***

<a name="avvio"></a>
## Avvio dell'applicazione
Una volta che l'utente avvia il programma sull'IDE come applicazione Spring Boot, quest'ultimo creerà un file per ognuno dei paesi europei con il nome di "{countryCode}_Relevant_Events" e salverà su ciascuno di essi le informazioni relative ai primi 5 eventi più rilevanti per ognuna delle 4 tipologie in cui essi vengono catalogati. Questi file verranno raccolti all'interno della directory "Relevant_Events", anch'essa creata all'avvio dell'applicazione.
Se sono già presenti file con lo stesso nome, il programma li aprirà e sovrascriverà gli eventi. 


<a name="rotte"></a>
## Rotte
L'utente può effettuare le richieste tramite Postman all'indirizzo:
```
localhost:8080
```
Le principali rotte definite sono le seguenti:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/countryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese scelto dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[2](#2) | ` GET ` | `/sourceCountryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese e i cui biglietti sono venduti dai distributori scelti dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[3](#3) | ` GET ` | `/segmentCountryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese e in base alla tipologia scelti dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[4](#4) | ` POST ` | `/filters` | *restituisce un JSONArray che mostra il numero di eventi di ogni elemento scelto per il confronto in base a un parametro ed entro un periodo di tempo inseriti dall'utente.*
[5](#5) | ` GET ` | `/saveEvents` | *restituisce il path in cui è stato salvato il file contenente le informazioni relative agli eventi che si svolgono nel paese inserito dall'utente.*


* ## In che modo l'utente può effettuare le richieste? Cosa ottiene come ouput?

L'utente deve avviare il programma sull'IDE come applicazione Spring Boot, successivamente deve aprire Postman per effettuare le richieste.
Innanzitutto si individua se la richiesta da effettuare è di tipo GET o POST, poiché in caso di scelta errata si riceverà un messaggio di errore.
Dopodiché si inserisce l'url della richiesta all'interno della barra, all'indirizzo precedentemente indicato.
Di seguito verranno illustrati alcuni esempi delle rotte principali, mostrando cosa dare in input e cosa ottenere in risposta.

<a name="1"></a>
## 1.   /countryEvents?countryCode={countryCode}

La prima rotta restituisce un JSONObject contentente a sua volta i JSONObject che riportano le informazioni relative agli eventi del paese selezionato, mentre in fondo sono presenti campi indicanti rispettivamente il numero di eventi mostrati ed il numero totale di eventi esistenti. Possono essere inseriti countryCode solo di paesi europei (la lista dei countryCode ammessi è presente sotto), altrimenti verrà lanciata un'eccezione.

Di seguito vengono mostrati i codici dei paesi europei supportati da Ticketmaster:

| Country | countryCode 
| ------------ | -------------------- 
| `Andorra` | `AD`
| `Austria`  |`AT`
| `Belgium` | `BE`
| `Bulgaria` | `BG`
| `Croatia`  |`HR`
| `Cyprus` | `CY`
| `Czech Republic` | `CZ`
| `Denmark`  |`DK`
| `Estonia` | `EE`
| `Faroe Islands`  |`FO`
| `Finland` | `FI`
| `France`  |`FR`
| `Georgia` | `GE`
| `Germany`  |`DE`
| `Gibraltar` | `GI`
| `Great Britain`  |`GB`
| `Greece` | `GR`
| `Hungary`  |`HU`
| `Iceland` | `IS`
| `Ireland`  |`IE`
| `Italy` | `IT`
| `Lithuania`  |`LT`
| `Luxembourg` | `LU`
| `Malta`  |`MT`
| `Monaco` | `MC`
| `Montenegro`  |`ME`
| `Netherlands` | `NL`
| `Northern Ireland`  |`ND`
| `Norway` | `NO`
| `Poland`  |`PL`
| `Portugal` | `PT`
| `Romania`  |`RO`
| `Russia` | `RU`
| `Serbia`  |`RS`
| `Slovakia` | `SK`
| `Slovenia`  |`SI`
| `Spain` | `ES`
| `Sweden`  |`SE`
| `Switzerland` | `CH`
| `Turkey`  |`TR`
| `Ukraine` | `UA`

Questa rotta può generare la seguente ***eccezione***:
  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```

In questo esempio sono state riportate le caratteristiche degli eventi che si svolgono in Germania.

```
localhost:8080/countryEvents?countryCode=DE
```

Se l'utente inserisce tutto correttamente, riceverà un JSONObject in risposta come segue:
 
```
{
    "Events": [
        {
            "country": "Germany",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.de/event/sc-potsdam-matchday-tickets/403579?language=en-us",
            "subGenre": "Volleyball",
            "countryCode": "DE",
            "segment": "Sports",
            "minPrice": 0,
            "genre": "Volleyball",
            "eventName": "SC Potsdam - matchday",
            "startTime": "19:00:00",
            "currency": "EUR",
            "id": "Z698xZC2Z178d4y",
            "maxPrice": 12,
            "startDate": "2021-02-17"
        },
        ...
		{
           "country": "Germany",
           "source": "ticketmaster",
           "url": "https://www.ticketmaster.de/event/capital-bra--samra-%7C-premium-seat-tickets/356519?language=en-us",
           "subGenre": "Hip-Hop/Rap",
           "countryCode": "DE",
           "segment": "Music",
           "minPrice": 115,
           "genre": "Hip-Hop/Rap",
           "eventName": "Capital Bra & Samra | Premium Seat",
           "startTime": "20:00:00",
           "currency": "EUR",
           "id": "Z698xZC2Z17upf_",
           "maxPrice": 115,
           "startDate": "2021-04-28"
        }
    ],
    "showedEvents": 200,
    "totalEvents": 1599
}
```

<a name="2"></a>
## 2.   /sourceCountryEvents?source={source}&countryCode={countryCode}

La seconda rotta restituisce un JSONObject contenente a sua volta i JSONObject che riportano le caratteristiche degli eventi del paese e del source selezionati. Possono essere inseriti solo countryCode di paesi europei e solo i source disponibili (la lista dei countryCode è mostrata all'interno della descrizione della rotta precedente, mentre quella dei source disponibili è riportata sotto), altrimenti verrà lanciata un'eccezione a seconda di quale parametro è stato inserito in modo errato.

Di seguito vengono mostrati i source supportati da Ticketmaster:

| Source 
| ------------ 
| `ticketmaster` 
| `universe ` 
| `frontgate ` 
| `tmr `

Questa rotta può generare le seguenti ***eccezioni***:
  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```
   
  * Nel caso in cui l'utente inserisca un source non esistente viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {source_errato} non è un valore ammesso.
   ```
   
In questo esempio sono state riportate le caratteristiche degli eventi che si svolgono in Gran Bretagna e in cui biglietti sono venduti da ticketmaster.

```
localhost:8080/sourceCountryEvents?source=ticketmaster&countryCode=GB
```

Se l'utente inserisce tutto correttamente, riceverà un JSONObject in risposta come segue:

```
{
    "Events": [
        {
            "country": "Great Britain",
            "address": "133a Rye Lane",
            "city": "London",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.co.uk/gabriel-garzonmontano-london-04-07-2020/event/35005855AAC8A96A",
            "marketId": "201",
            "subGenre": "Soul",
            "marketName": "All of United Kingdom",
            "countryCode": "GB",
            "segment": "Music",
            "minPrice": 14.5,
            "genre": "R&B",
            "eventName": "Gabriel Garzon-Montano",
            "startTime": "19:30:00",
            "currency": "GBP",
            "placement": "Peckham Audio",
            "id": "1AgZA-4Gkenw1Pn",
            "maxPrice": 14.5,
            "startDate": "2020-04-07"
        },
        ...
		{
            "country": "Great Britain",
            "address": "Coventry Street",
            "city": "London",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.co.uk/the-book-of-mormon-groups-london-02-20-2021/event/350058ACE2ED27CE",
            "marketId": "201",
            "subGenre": "Musical",
            "marketName": "All of United Kingdom",
            "countryCode": "GB",
            "segment": "Arts & Theatre",
            "minPrice": 0,
            "genre": "Theatre",
            "eventName": "The Book of Mormon - Groups",
            "startTime": "14:30:00",
            "placement": "Prince of Wales Theatre",
            "id": "17u8vbG61SxD3LC",
            "maxPrice": 0,
            "startDate": "2021-02-20"
        }
    ],
    "showedEvents": 200,
    "totalEvents": 23908
}
```

<a name="3"></a>
## 3.   /segmentCountryEvents?segment={segment}&countryCode={countryCode}

La terza rotta restituisce un JSONObject contenente a sua volta i JSONObject che riportano le caratteristiche degli eventi del paese e della tipologia selezionati. Possono essere inseriti solo countryCode di paesi europei e solo le tipologie disponibili (la lista dei countryCode è mostrata precedentemente, mentre quella dei segment disponibili è riportata sotto), altrimenti verrà lanciata un'eccezione a seconda di quale parametro è stato inserito in modo errato.

Di seguito vengono mostrate le tipologie in cui vengono catalogati gli eventi:

| Segment 
| ------------ 
| `Arts` 
| `Miscellaneous` 
| `Music` 
| `Sports`

Questa rotta può generare le seguenti ***eccezioni***:
  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```
   
  * Nel caso in cui l'utente inserisca un segment non esistente viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {segment_errato} non è un valore ammesso.
   ```
   
In questo esempio sono state riportate le caratteristiche degli eventi musicali che si svolgono nei Paesi Bassi.

```
localhost:8080/segmentCountryEvents?segment=Music&countryCode=NL
```

Se l'utente inserisce tutto correttamente, riceverà un JSONObject in risposta come segue:

```
{
    "Events": [
        {
            "country": "Netherlands",
            "address": "Vredenburgkade 11",
            "city": "Utrecht",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.nl/event/ntjam-rosie-tickets/252387?language=en-us",
            "subGenre": "Other",
            "countryCode": "NL",
            "segment": "Music",
            "minPrice": 17,
            "genre": "Other",
            "eventName": "Ntjam Rosie",
            "startTime": "20:30:00",
            "currency": "EUR",
            "placement": "TivoliVredenburg",
            "id": "Z698xZbpZ17a3C6",
            "maxPrice": 17,
            "startDate": "2021-02-17"
        },
        ...
        {
            "country": "Netherlands",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.nl/event/klub-kids-tickets/259267?language=en-us",
            "subGenre": "Other",
            "countryCode": "NL",
            "segment": "Music",
            "minPrice": 23,
            "genre": "Other",
            "eventName": "Klub Kids",
            "startTime": "20:00:00",
            "currency": "EUR",
            "id": "Z698xZbpZ17a_aE",
            "maxPrice": 57.5,
            "startDate": "2021-05-12"
        }
    ],
    "showedEvents": 200,
    "totalEvents": 846
}
```


<a name=4></a>
## 4.    /filters

La quarta rotta è di tipo POST e richiede un body di questo tipo:

```
{
	 "comparison": "country",
     "elements": [
        {
          "name": "GB"
        },
        {
          "name": "DE"
        },
        {
          "name": "FR"
        }
      ],
     "param": "segment",
     "value": "Sports",
     "period": 6
 }
```

- **comparison** rappresenta che tipo di elementi si vogliono confrontare tra loro: si possono confrontare tra loro "country", "market", "segment", "genre", "subgenre" o "source".
- **elements** sono gli elementi che si vogliono confrontare. 
- **param** rappresenta il parametro su cui si vuole effettuare il confronto (è uno tra "segment", "genre", "subGenre, "source", "country" o "total"); nel caso in cui comparison sia country oppure market, allora param può assumere il valore total ad indicare la scelta divoler conoscere il numero totale di eventi (nel caso in cui comparison sia uguale a market allora param può assumere solo il valore total); nel caso in cui comparison non sia né country né market, allora param può assumeresolamente il valore country.
- **value** rappresenta il valore del parametro su cui si vuole effettuare il confronto.
- **period** indica il periodo temporale (in mesi) su cui si vuole effettuare il confronto (può essere un valore tra 1, 3, 6 oppure 12)
 
Questa rotta può generare le seguenti ***eccezioni***: 

   * Nel caso in cui l'utente inserisca un valore di comparison non ammesso viene generata un'eccezione del tipo ***WrongComparisonException*** che restituisce un messaggio di questo tipo:
   
```
{comparison_errato} non è una stringa ammessa. Inserisci una stringa tra country, market, source, segment, genre o subgenre.
```

  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```

   * Nel caso in cui l'utente inserisca un valore errato che non sia un countryCode viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {valore_errato} non è un valore ammesso.
   ```
   
* Nel caso in cui comparison sia country e l'utente inserisca un param errato viene generata un'eccezione del tipo ***WrongParameterException*** che restituisce un messaggio di questo tipo:

 ```
{param_errato} non è un parametro ammesso. Inserisci una stringa tra total, segment, genre, subGenre, source.
```

   * Nel caso in cui comparison sia market e l'utente inserisca un param errato viene generata un'eccezione del tipo ***WrongParameterException*** che restituisce un messaggio di questo tipo:

 ```
{param_errato} non è un parametro ammesso. Puoi inserire solo la stringa total.
```

   * Nel caso in cui comparison non sia né country né market e l'utente inserisca un param errato viene generata un'eccezione del tipo ***WrongParameterException*** che restituisce un messaggio di questo tipo:

 ```
{param_errato} non è un parametro ammesso. Puoi inserire solo la stringa country.
```
   * Nel caso in cui l'utente inserisca un periodo errato viene generata un'eccezione del tipo ***WrongPeriodException*** che restituisce un messaggio di questo tipo:

   ```
 {period_errato} non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.
   ```

Se l'utente inserisce tutto correttamente, riceverà un JSONArray in risposta come segue:

   ```
[
    {
        "country: ": "GB",
        "totalEvents: ": 98
    },
    {
        "country: ": "DE",
        "totalEvents: ": 27
    },
    {
        "country: ": "FR",
        "totalEvents: ": 0
    },
    {
        "Country with most events: ": "GB",
        "totalEvents: ": 98
    },
    {
        "Country with least events: ": "FR",
        "totalEvents: ": 0
    }
]
   ```

Nel caso in cui l'utente voglia confrontare tutti i paesi europei per individuare quanti eventi presentino ciascuno e stabilire quale paese ospiti il maggiore e quale il minor numero di eventi durante un arco temporale, deve inserire un body di questo tipo:

   ```
{
	 "comparison": "country",
     "elements": [
        {
          "name": "GB"
        },
        {
          "name": "DE"
        },
        {
          "name": "FR"
        }
      ],
     "param": "total",
     "value": "all",
     "period": 1
 }
   ```
L'utente riceverà un JSONArray in risposta come segue:
```
[
{"country: ":"AD","totalEvents: ":0},
{"country: ":"AT","totalEvents: ":0},
{"country: ":"BE","totalEvents: ":64},
{"country: ":"BG","totalEvents: ":0},
{"country: ":"HR","totalEvents: ":0},
{"country: ":"CY","totalEvents: ":0},
{"country: ":"CZ","totalEvents: ":3},
{"country: ":"DK","totalEvents: ":31},
{"country: ":"EE","totalEvents: ":0},
{"country: ":"FO","totalEvents: ":0},
{"country: ":"FI","totalEvents: ":4},
{"country: ":"FR","totalEvents: ":0},
{"country: ":"DE","totalEvents: ":61},
{"country: ":"GE","totalEvents: ":0},
{"country: ":"GI","totalEvents: ":0},
{"country: ":"GB","totalEvents: ":1335},
{"country: ":"GR","totalEvents: ":0},
{"country: ":"HU","totalEvents: ":0},
{"country: ":"IS","totalEvents: ":0},
{"country: ":"IE","totalEvents: ":42},
{"country: ":"IT","totalEvents: ":0},
{"country: ":"LT","totalEvents: ":0},
{"country: ":"LU","totalEvents: ":0},
{"country: ":"MT","totalEvents: ":0},
{"country: ":"MC","totalEvents: ":0},
{"country: ":"ME","totalEvents: ":0},
{"country: ":"NL","totalEvents: ":162},
{"country: ":"ND","totalEvents: ":0},
{"country: ":"NO","totalEvents: ":4},
{"country: ":"PL","totalEvents: ":25},
{"country: ":"PT","totalEvents: ":0},
{"country: ":"RO","totalEvents: ":0},
{"country: ":"RU","totalEvents: ":0},
{"country: ":"RS","totalEvents: ":0},
{"country: ":"SK","totalEvents: ":0},
{"country: ":"SI","totalEvents: ":0},
{"country: ":"ES","totalEvents: ":8},
{"country: ":"SE","totalEvents: ":18},
{"country: ":"CH","totalEvents: ":15},
{"country: ":"TR","totalEvents: ":0},
{"country: ":"UA","totalEvents: ":0},
{"Country with most events: ":"GB","totalEvents: ":1335},
{"Country with least events: ":"UA","totalEvents: ":0}]
```


<a name=4></a>
## 5.   /saveEvents?countryCode={countryCode}

La quinta rotta permette di salvare le informazioni relative agli eventi del paese inserito dall'utente. Il programma creerà un file col nome "{countryCode}_Total_Events.txt", dopo aver creato una cartella di nome "Total_Events", e lo inserirà all'interno di questa directory. Se è già presente un file con lo stesso nome, il programma lo aprirà e sovrascriverà gli eventi.

Questa rotta può generare la seguente ***eccezione***:
  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```

Di seguito viene proposto un esempio di utilizzo di questa rotta:
```
localhost:8080/saveEvents?countryCode=DE
```

Se il countryCode inserito è corretto, si riceverà un messaggio di questo tipo:

```
Il file è stato salvato in C:\Users\loren\git\ProgettoOOP\TicketmasterEurope\Total_Events\DE_Total_Events.txt
```

  
 <a name="rotteaggiuntive"></a>
## Rotte Aggiuntive

Il nostro programma offre la possibilità di ottenere le informazioni relative agli eventi in base a vari parametri passati in ingresso, attraverso le seguenti rotte:

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[6](#6) | ` GET ` | `/marketEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel market scelto dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[7](#7) | ` GET ` | `/genreCountryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese e in base al genere indicati dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[8](#8) | ` GET ` | `/subgenreCountryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese e in base al sottogenere selezionati dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*
[9](#9) | ` GET ` | `/keywordCountryEvents` | *restituisce un JSONObject che mostra le caratteristiche degli eventi che hanno luogo nel paese e in base alla parola chiave inseriti dall'utente, oltre al numero di eventi mostrati e al numero totale di eventi.*


* ## In che modo l'utente può effettuare le richieste? Cosa ottiene come ouput?

<a name=6></a>
## 6.   /marketEvents?marketId={marketId}

La sesta rotta restituisce un JSONObject contentente a sua volta i JSONObject che riportano le informazioni relative agli eventi del market selezionato, mentre in fondo sono presenti campi indicanti rispettivamente il numero di eventi mostrati ed il numero totale di eventi esistenti. Possono essere inseriti marketId solo di paesi europei (la lista dei marketId ammessi è mostrata sotto), altrimenti verrà lanciata un'eccezione.

Di seguito vengono mostrati i market appartenenti al territorio europeo supportati da Ticketmaster:

| ID | Market 
| ------------ | -------------------- 
| `202` | `London (UK)` 
| `203` | `South (UK)` 
| `204` | `Midlands and Central (UK)` 
| `205` | `Wales and North West (UK)` 
| `206` | `North and North East (UK)` 
| `207` | `Scotland` 
| `208` | `Ireland` 
| `209` | `Northern Ireland` 
| `210` | `Germany`
| `211` | `Netherlands`
| `500` | `Sweden`
| `501` | `Spain`
| `502` | `	Barcelona (Spain)`
| `503` | `Madrid (Spain)`
| `600` | `Turkey`

Questa rotta può generare la seguente ***eccezione***:
  * Nel caso in cui l'utente inserisca un marketId di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {marketId_errato} non è un valore ammesso.
   ```

In questo esempio sono state riportate le caratteristiche degli eventi che si svolgono nel market della Scozia.

```
localhost:8080/marketEvents?marketId=207
```

Se l'utente inserisce tutto correttamente, riceverà un JSONObject in risposta come segue:
```
{
    "Events": [
        {
            "country": "Great Britain",
            "address": "490 Sauchiehall Street",
            "city": "Glasgow",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.co.uk/denis-coleman-glasgow-02-19-2021/event/3600584B9DB827B8",
            "marketId": "201",
            "subGenre": "Pop",
            "marketName": "All of United Kingdom",
            "countryCode": "GB",
            "segment": "Music",
            "minPrice": 13.75,
            "genre": "Pop",
            "eventName": "Denis Coleman",
            "startTime": "19:00:00",
            "currency": "GBP",
            "placement": "Attic Bar  - Glasgow Garage",
            "id": "1AdbZp7Gkmqmerz",
            "maxPrice": 13.75,
            "startDate": "2021-02-19"
        },
        ...
        {
            "country": "Great Britain",
            "address": "Belmont St",
            "city": "Aberdeen",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.co.uk/shambolics-aberdeen-04-23-2021/event/3600594CB5B21FDE",
            "marketId": "201",
            "subGenre": "Alternative Rock",
            "marketName": "All of United Kingdom",
            "countryCode": "GB",
            "segment": "Music",
            "minPrice": 11,
            "genre": "Rock",
            "eventName": "Shambolics",
            "startTime": "20:00:00",
            "currency": "GBP",
            "placement": "Cafe Drummond",
            "id": "1AdbZpfGkwgi-Tr",
            "maxPrice": 11,
            "startDate": "2021-04-23"
        }
    ],
    "showedEvents": 200,
    "totalEvents": 1757
}
```


<a name=7></a>
## 7.   /genreCountryEvents?genre={genre}&countryCode={countryCode}

La settima rotta restituisce un JSONObject contenente a sua volta i JSONObject che riportano le caratteristiche degli eventi del paese e del genere selezionati. Possono essere inseriti solo countryCode di paesi europei e solo i generi disponibili (la lista dei countryCode è mostrata precedentemente, mentre quella dei genre ammessi è riportata all'interno del file "Codes and Names"), altrimenti verrà lanciata un'eccezione a seconda di quale parametro è stato inserito in modo errato.

Questa rotta può generare le seguenti ***eccezioni***:

  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```
   
  * Nel caso in cui l'utente inserisca un genre non esistente viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {genre_errato} non è un valore ammesso.
   ```
   
In questo esempio sono state riportate le caratteristiche degli eventi Rock che si svolgono in Belgio.

```
localhost:8080/genreCountryEvents?genre=Rock&countryCode=BE
```


Se l'utente inserisce tutto correttamente, otterrà un JSONObject di questo tipo:

```
{
    "Events": [
        {
            "country": "Belgium",
            "address": "Rue de Tubize 28",
            "city": "Ittre",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.be/event/tribute-to-such-a-noise--alain-pire-exp--froidebise-trio-tickets/42513",
            "subGenre": "Pop",
            "countryCode": "BE",
            "segment": "Music",
            "minPrice": 15.25,
            "genre": "Rock",
            "eventName": "Tribute to Such a Noise + Alain Pire exp. + Froidebise trio",
            "startTime": "20:45:00",
            "currency": "EUR",
            "placement": "ZIK-ZAK",
            "id": "Z698xZG2Za1bo",
            "maxPrice": 15.25,
            "startDate": "2021-03-05"
        },
        ...
        {
            "country": "Belgium",
            "address": "Monacoplein",
            "city": "Oostende",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.be/event/clannad-in-a-lifetime-farewell-tour-tickets/37277",
            "subGenre": "Folk",
            "countryCode": "BE",
            "segment": "Music",
            "minPrice": 36,
            "genre": "Folk",
            "eventName": "Clannad - 'In A Lifetime' Farewell Tour",
            "startTime": "20:00:00",
            "currency": "EUR",
            "placement": "Kursaal Oostende",
            "id": "Z698xZG2Zaakq",
            "maxPrice": 51,
            "startDate": "2022-04-07"
        }
    ],
    "showedEvents": 197,
    "totalEvents": 197
}        
```


<a name=8></a>
## 8.   /subgenreCountryEvents?genre={genre}&countryCode={countryCode}

L'ottava rotta restituisce un JSONObject contenente a sua volta i JSONObject che riportano le caratteristiche degli eventi del paese e del sottogenere selezionati. Possono essere inseriti solo countryCode di paesi europei e solo i sottogeneri disponibili (la lista dei countryCode è mostrata precedentemente, mentre quella dei subgenre ammessi è riportata all'interno del file "Codes and Names"), altrimenti verrà lanciata un'eccezione a seconda di quale parametro è stato inserito in modo errato.

Questa rotta può generare le seguenti ***eccezioni***:

  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```
   
  * Nel caso in cui l'utente inserisca un subgenre non esistente viene generata un'eccezione del tipo ***WrongValueException*** che restituisce un messaggio di questo tipo:

   ```
    {subgenre_errato} non è un valore ammesso.
   ```

In questo esempio sono state riportate le caratteristiche degli eventi di danza che si svolgono in Irlanda.

```
localhost:8080/subgenreCountryEvents?subgenre=Dance&countryCode=IE
```

Se l'utente inserisce tutto correttamente, otterrà un JSONObject di questo tipo:

```
{
    "Events": [
        {
            "country": "Ireland",
            "address": "East Link Bridge",
            "city": "Dublin",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.ie/diversity-connected-2022-dublin-06-03-2022/event/1800594899A812ED",
            "marketId": "208",
            "subGenre": "Dance",
            "marketName": "Ireland",
            "countryCode": "IE",
            "segment": "Arts & Theatre",
            "minPrice": 38.5,
            "genre": "Dance",
            "eventName": "Diversity - Connected 2022",
            "startTime": "14:30:00",
            "currency": "EUR",
            "placement": "3Arena",
            "id": "16vOZpfx_G7nv5c",
            "maxPrice": 48.5,
            "startDate": "2022-06-03"
        }
    ],
    "showedEvents": 1,
    "totalEvents": 1
}
```


<a name=9></a>
## 9.   /keywordCountryEvents?keyword={keyword}&countryCode={countryCode}

L'ultima rotta restituisce un JSONObject contenente a sua volta i JSONObject che riportano le caratteristiche degli eventi del paese selezionato tramite una parola chiave. Possono essere inseriti solo countryCode di paesi europei (la lista dei countryCode è mostrata precedentemente), altrimenti verrà lanciata un'eccezione.

Questa rotta può generare la seguente ***eccezione***:

  * Nel caso in cui l'utente inserisca un countryCode di un paese non europeo oppure non esistente viene generata un'eccezione del tipo ***WrongCountryException*** che restituisce un messaggio di questo tipo:

   ```
    {countryCode_errato} non è un valore ammesso.
   ```
   

In questo esempio sono state riportate le caratteristiche degli eventi di che si svolgono in Spagna inserendo la parola chiave "concerts".

```
localhost:8080/keywordCountryEvents?keyword=concerts&countryCode=ES
```

Se l'utente inserisce tutto correttamente, otterrà un JSONObject di questo tipo:

```
{
    "Events": [
        {
            "country": "Spain",
            "address": "Calle Avenida (Poblado Sancti Petri)",
            "city": "Chiclana de la Frontera",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.es/event/loquillo-concert-music-festival-tickets/22171?language=en-us",
            "subGenre": "Pop",
            "countryCode": "ES",
            "segment": "Music",
            "minPrice": 44,
            "genre": "Rock",
            "eventName": "Loquillo - Concert Music Festival",
            "startTime": "22:30:00",
            "currency": "EUR",
            "placement": "Sancti Petri",
            "id": "Z698xZ2qZaAQh",
            "maxPrice": 1400,
            "startDate": "2021-07-09"
        },
        ...
        {
            "country": "Spain",
            "address": "Calle Avenida (Poblado Sancti Petri)",
            "city": "Chiclana de la Frontera",
            "source": "ticketmaster",
            "url": "https://www.ticketmaster.es/event/el-barrio-concert-music-festival-tickets/22359?language=en-us",
            "subGenre": "Pop",
            "countryCode": "ES",
            "segment": "Music",
            "minPrice": 44,
            "genre": "Rock",
            "eventName": "El Barrio - Concert Music Festival",
            "startTime": "22:30:00",
            "currency": "EUR",
            "placement": "Sancti Petri",
            "id": "Z698xZ2qZaAq9",
            "maxPrice": 1400,
            "startDate": "2021-08-21"
        }
    ],
    "showedEvents": 8,
    "totalEvents": 8
}
```


<a name="test"></a>
## Test

Abbiamo implementato i seguenti [test](https://github.com/lorenzoromandini/ProgettoOOP/tree/main/TicketmasterEurope/src/test/java/eu/univpm/TicketmasterEurope) per verificare il corretto funzionamento di alcuni metodi e delle eccezioni implementate.

* eu.univpm.TicketmasterEurope.service

Abbiamo testato l'effettivo funzionamento del meccanismo che converte un oggetto di tipo EventsArray in un JSONObject.

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/ServiceTest_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.filters
 
Abbiamo verificato l'effettiva esecuzione delle eccezioni relative all'inserimento di un comparison, di un param o di un period errati.

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/FiltersTest_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.stats

Abbiamo testato l'esecuzione corretta del lancio di eccezioni legate all'inserimento di countryCode o value errati.

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/StatsTest_ClassDiagram.png)

* eu.univpm.TicketmasterEurope.saves

Abbiamo verificato l'effettiva creazione della directory e dei file contenuti al suo interno.

![alt_text](https://github.com/lorenzoromandini/ProgettoOOP/blob/main/TicketmasterEurope/UML/SavesTest_ClassDiagram.png)


<a name="doc"></a>
## Documentazione
Il codice Java è interamente documentato in [Javadoc](https://github.com/lorenzoromandini/ProgettoOOP/tree/main/TicketmasterEurope/doc).


<a name="autor"></a>
### Autori
Il progetto è stato realizzato da :
- Lorenzo Romandini
- Nicholas Urbanelli 

