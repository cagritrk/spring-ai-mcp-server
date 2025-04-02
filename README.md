# Spring AI MCP Server Example

This is a sample Spring AI MCP Server project built for fun and experimentation. It implements basic CRUD operations using an in-memory data store with dummy Person data.

## Project Overview

The project demonstrates:
- Implementation of a PersonService with CRUD operations
- In-memory data storage for Person entities
- Spring MCP Tools annotations and required code to create an MCP Server

## Technologies

- **Java 24**
- **Spring Boot 3.4.4**
- **Spring AI 1.0.0-M6**

## How to Run

1. Build the project:
```bash
mvn clean install
```

2. Start the MCP server:
```bash
java -jar target/spring-ai-mcp-0.0.1-SNAPSHOT.jar
```

## MCP Server Configuration

```json
{
  "mcpServers": {
    "cagritrk-inmemory-data-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "<YOUR_PATH>\\spring-ai-mcp\\target\\spring-ai-mcp-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```

## Tools of `cagritrk-inmemory-data-mcp-server`

- **ps_delete_person**: Delete a person record by ID from the in-memory store.  
  **Input**: `id` (integer)

- **ps_search_by_job_title**: Search for persons by job title in the in-memory store.  
  **Input**: `jobTitleQuery` (string)

- **ps_filter_by_sex**: Filter persons by sex (case-insensitive).  
  **Input**: `sex` (string)

- **ps_filter_by_age**: Filter persons by age.  
  **Input**: `age` (integer)

- **ps_update_person**: Update an existing person record by ID in the in-memory store.  
  **Input**: `id` (integer), `updatedPersonData` (object)

- **ps_create_person**: Create a new person record in the in-memory store.  
  **Input**: `personData` (object)

- **ps_get_all_persons**: Retrieve all person records from the in-memory store.  
  **Input**: None

- **ps_get_person_by_id**: Retrieve a person record by ID from the in-memory store.  
  **Input**: `id` (integer)

## Demo Screenshots

### `Create new Person`

![ps_create_person](https://github.com/user-attachments/assets/054e54ae-3ca6-4403-9a3a-073f5e11cfe0)

### `Get the list of Persons`

![ps_get_all_persons](https://github.com/user-attachments/assets/0e475021-b06b-4f63-9920-022bed8bc639)

### `How many male person records are there?`

![ps_filter_by_sex](https://github.com/user-attachments/assets/a0ae8757-5389-409e-a956-098e80295243)

## CSV Data

The project uses the following sample CSV data:

<details>

<summary>people-100.csv</summary>

```csv
Index,User Id,First Name,Last Name,Sex,Email,Phone,Date of birth,Job Title
1,88F7B33d2bcf9f5,Shelby,Terrell,Male,elijah57@example.net,001-084-906-7849x73518,1945-10-26,Games developer
2,f90cD3E76f1A9b9,Phillip,Summers,Female,bethany14@example.com,214.112.6044x4913,1910-03-24,Phytotherapist
3,DbeAb8CcdfeFC2c,Kristine,Travis,Male,bthompson@example.com,277.609.7938,1992-07-02,Homeopath
4,A31Bee3c201ef58,Yesenia,Martinez,Male,kaitlinkaiser@example.com,584.094.6111,2017-08-03,Market researcher
5,1bA7A3dc874da3c,Lori,Todd,Male,buchananmanuel@example.net,689-207-3558x7233,1938-12-01,Veterinary surgeon
6,bfDD7CDEF5D865B,Erin,Day,Male,tconner@example.org,001-171-649-9856x5553,2015-10-28,Waste management officer
7,bE9EEf34cB72AF7,Katherine,Buck,Female,conniecowan@example.com,+1-773-151-6685x49162,1989-01-22,Intelligence analyst
8,2EFC6A4e77FaEaC,Ricardo,Hinton,Male,wyattbishop@example.com,001-447-699-7998x88612,1924-03-26,Hydrogeologist
9,baDcC4DeefD8dEB,Dave,Farrell,Male,nmccann@example.net,603-428-2429x27392,2018-10-06,Lawyer
10,8e4FB470FE19bF0,Isaiah,Downs,Male,virginiaterrell@example.org,+1-511-372-1544x8206,1964-09-20,"Engineer, site"
11,BF0BbA03C29Bb3b,Sheila,Ross,Female,huangcathy@example.com,895.881.4746,2008-03-20,Advertising account executive
12,F738c69fB34E62E,Stacy,Newton,Male,rayleroy@example.org,710.673.3213x80335,1980-10-20,Warden/ranger
13,C03fDADdAadAdCe,Mandy,Blake,Male,jefferynoble@example.org,(992)466-1305x4947,2007-12-08,"Scientist, clinical (histocompatibility and immunogenetics)"
14,b759b74BD1dE80d,Bridget,Nash,Female,mercedes44@example.com,(216)627-8359,2004-06-28,Social worker
15,1F0B7D65A00DAF9,Crystal,Farmer,Male,pmiranda@example.org,+1-024-377-5391,1992-03-09,Agricultural consultant
16,50Bb061cB30B461,Thomas,Knight,Female,braunpriscilla@example.net,+1-360-880-0766,2006-02-18,Sport and exercise psychologist
17,D6dbA5308fEC4BC,Maurice,Rangel,Male,sheenabanks@example.com,(246)187-4969,2004-08-20,Secretary/administrator
18,311D775990f066d,Frank,Meadows,Male,gbrewer@example.org,429.965.3902x4447,2008-09-16,Audiological scientist
19,7F7E1BAcb0C9AFf,Alvin,Paul,Male,gilbertdonaldson@example.com,219.436.0887x07551,1949-05-12,"Teacher, adult education"
20,88473e15D5c3cD0,Jared,Mitchell,Female,jcortez@example.com,+1-958-849-6781,1921-01-18,Paediatric nurse
21,b31D271F8c200AB,Jacqueline,Norton,Female,carias@example.net,819.309.7679x59173,1952-10-09,"Scientist, marine"
22,42F4BdA841aBadC,Colleen,Hatfield,Female,fknox@example.org,638.584.1090,1949-10-14,Commercial horticulturist
23,cBbBcA0FCA3C4Bc,Randy,Barnes,Male,huangbill@example.org,001-960-629-7164x67214,1947-12-30,Outdoor activities/education manager
24,f1f89173353aD90,Janice,Rhodes,Female,juarezdominique@example.net,001-249-314-9742x6996,1999-11-01,Drilling engineer
25,c5B09fb33e8bA0A,Alfred,Mcneil,Female,cassandramorris@example.com,(468)276-9509x53058,1993-05-28,Systems analyst
26,c9F2282C40BEC1E,Sean,Levine,Male,sallymiller@example.net,4915828504,2010-10-09,"Conservation officer, nature"
27,9c1bc7EC53Fb7cE,Louis,Payne,Male,bsullivan@example.net,6232695307,1916-01-29,Counsellor
28,ddEc50e2A2e3a2B,Brittney,Vega,Female,ayalajose@example.net,945-739-8686,1932-10-31,Recycling officer
29,66F096D36Ebae11,Judy,Buckley,Male,irosales@example.net,001-654-208-1241x52830,1963-07-28,Art gallery manager
30,F0fE2faAd78F8b5,Norman,Weber,Male,mconrad@example.com,223.002.0429,1957-05-21,Gaffer
31,5d2feAfbdCAA6B5,Isaiah,Camacho,Female,jimblake@example.org,001-536-544-3367,1966-04-07,Food technologist
32,cDa5F303fCd6dEa,Jacqueline,Gallagher,Male,nsampson@example.net,(247)762-8934,1999-02-25,Building services engineer
33,8Ef7DBfcaB02b6B,Bonnie,Andrews,Female,caitlin24@example.net,+1-253-987-2776x9161,1953-12-21,Seismic interpreter
34,6Dec5b5542F8ed8,Brandon,Schmidt,Female,mconley@example.net,+1-386-673-1465x006,1931-05-12,"Engineer, biomedical"
35,3Fb8a7f68e12784,Jackson,Sparks,Female,reynoldsdarryl@example.net,(137)908-3129x65035,1980-11-18,Set designer
36,035eff50B9A0F24,Melody,Cook,Male,jeannovak@example.org,(826)792-7381,1963-06-25,Research scientist (life sciences)
37,aa614aAE4B7Cf0C,Leonard,Hurst,Male,clinton78@example.org,941-038-0427x38800,1938-03-13,"Accountant, chartered management"
38,ACcde95AAe3e6cC,Gene,Rich,Female,luisdeleon@example.org,+1-356-818-6604x89537,1946-08-22,"Surveyor, quantity"
39,b6a35de5CB6fc25,Cynthia,Wiggins,Female,rosariodave@example.org,(110)858-2437x70190,1984-01-27,Outdoor activities/education manager
40,e92A191E345fA3A,Tanya,Mckinney,Female,vickihouston@example.com,(830)774-9002x086,2003-03-12,Information systems manager
41,7D0AcBF6CCac3fd,Matthew,Stone,Female,evelyn31@example.org,952-381-6360,2017-08-23,"Scientist, clinical (histocompatibility and immunogenetics)"
42,CEFA7BBCef013AE,Kirk,Walsh,Female,stephenfuller@example.org,001-826-496-5529x8661,2009-04-08,Accounting technician
43,9edBC94aE7cA22a,Willie,Vang,Female,haleymathews@example.net,741.168.6854x067,1978-02-02,Management consultant
44,fFe7BAA737aDbe2,Miguel,Hill,Female,tyrone56@example.org,5247842945,1930-08-26,Make
45,5F2f3fAca8B0946,Darren,Andrews,Male,lhernandez@example.com,(975)799-4261,1997-10-04,Retail banker
46,6bFcfc3cc1BC6B4,Haley,Pugh,Female,molly03@example.org,(746)182-6137x2453,1980-09-16,Commissioning editor
47,f3BD2cBF7eEb6df,Danielle,Estrada,Female,jvang@example.org,(890)374-9518x772,1930-07-09,"Accountant, chartered management"
48,Ee4eB129dC7913A,Becky,Brady,Male,erikmueller@example.org,(390)002-0863,1957-06-27,Seismic interpreter
49,dBCEf340C3657Eb,Caitlyn,Frey,Male,rivasdominique@example.org,805-021-3965x46344,1968-01-26,Jewellery designer
50,E47FB71DD9ACCd9,Joshua,Sweeney,Male,daisymcgee@example.net,875.994.2100x535,1954-07-28,"Education officer, museum"
51,eA3fDd79BE9f0E7,Heidi,Escobar,Female,staffordtravis@example.net,601-155-3065x1131,1931-09-25,Estate manager/land agent
52,aF0eE4547Bc025c,Brian,Oconnell,Female,saralong@example.net,952-283-1423x733,1911-10-23,Physiotherapist
53,9F5DeD7aD228F5a,Beverly,Esparza,Female,iphelps@example.net,+1-327-578-8754x6771,1930-12-09,Passenger transport manager
54,D3Fa0220dDE4d36,Nathaniel,Rivas,Female,roberto29@example.com,(655)887-2040x37888,1908-11-17,Call centre manager
55,60FdBFd5e7BE8fF,Debra,Payne,Female,yolanda07@example.org,001-731-525-8400x52593,1927-08-20,Special educational needs teacher
56,D8bF5Ab2b98caff,Mackenzie,Rocha,Female,abbottyvette@example.net,4225525458,1980-10-21,Museum/gallery exhibitions officer
57,CD8d33aA25bc8BB,Courtney,Watkins,Female,ochang@example.org,210.683.2761x5883,2003-12-07,Pension scheme manager
58,Fac3BfFf0A3d03c,Fred,Olsen,Female,amyanderson@example.com,497-774-3053,1910-04-10,Archaeologist
59,e552D7ddafe1FFb,Ryan,Nelson,Female,qnorman@example.org,956.330.2951,1924-05-02,Historic buildings inspector/conservation officer
60,0f8deedb629A5f6,Grace,Phelps,Male,clarkeangela@example.net,(034)867-8827x6777,1909-10-15,Petroleum engineer
61,bB9e49E506F65ed,Shari,Daugherty,Male,kalvarado@example.org,001-951-655-4798x6124,1944-11-24,Curator
62,Ed724605A403D91,Kelli,Garner,Male,jodyvincent@example.org,995.000.4213x0982,2010-01-17,Retail banker
63,0aBE5ACb18E0c10,Jackie,Bennett,Male,hutchinsonkirk@example.com,001-740-937-0846x0087,1915-11-11,Neurosurgeon
64,5D2cb63CaAF53f6,Leslie,Conway,Female,floreschristina@example.org,795.782.4384x555,1983-11-06,Chiropractor
65,Ee6974f90eeCe18,Harold,Barnett,Female,nathan65@example.org,+1-026-265-6392,1943-03-15,"Biochemist, clinical"
66,cEf02C076afa07f,Larry,Harper,Male,maria32@example.org,+1-244-630-3792x4121,2021-05-05,"Scientist, water quality"
67,9Df5Ba591bF3EFf,Mike,Ward,Female,imccullough@example.com,116-729-5046,1967-11-09,Hydrologist
68,3faB1CBfEFBDdD4,Brittney,Rubio,Female,corey92@example.com,593.976.2528,1959-12-24,"Biochemist, clinical"
69,Ebcefdf75eCb0a9,Frank,Pineda,Male,daltoncalvin@example.net,(035)961-5060x9182,1926-03-10,Hospital pharmacist
70,e75e5DBfcb68887,Sandra,Wu,Male,ubanks@example.com,+1-096-606-6454x067,1925-04-28,Warehouse manager
71,6a53a8D41dDF6de,Ryan,Benton,Male,lopezdebbie@example.org,+1-695-557-9948x485,2020-10-06,Physiological scientist
72,F0d3bD1aaf9E3Bc,Tamara,Hull,Male,meagan39@example.net,017.665.3744x7944,1933-01-31,English as a second language teacher
73,5bC87340799FBD0,Jean,Ritter,Female,kristina76@example.com,(954)060-1066,1985-08-06,Financial trader
74,dBfA17Aaf16b4ab,Veronica,Briggs,Female,weissbridget@example.com,+1-521-589-2387x48490,1974-06-08,Structural engineer
75,c935b7Eb6FA0B0F,Kim,Andrews,Female,wpetersen@example.org,7677125383,1990-11-15,"Biochemist, clinical"
76,b3e15e65Ca2CcBf,Tina,Cunningham,Male,wongmary@example.org,079-907-5051,1956-11-29,Race relations officer
77,dade3452F0c32FD,Jonathon,Atkinson,Male,gailfrench@example.net,874-037-2032x932,2011-07-19,"Psychologist, forensic"
78,AdEd6cfD85DeC46,Jermaine,Reid,Female,vpaul@example.com,(742)214-8691,1974-08-18,Newspaper journalist
79,DAf111987098ae4,Regina,Stevens,Male,xpoole@example.net,891-359-2684,2011-11-28,Public house manager
80,6e6a5b885F6496d,Terrence,Huff,Male,cassandra80@example.org,221.800.6408x5416,1944-02-27,Careers information officer
81,12DCb4ED8E01D5C,Tyler,Foley,Female,johnathan72@example.org,001-386-469-3075x8030,1908-09-19,Economist
82,E1cB5cA8CA7CC0a,Andrew,Waters,Male,nhall@example.net,+1-376-865-2765x3351,1948-05-14,Jewellery designer
83,AedDfaE8Cf49F07,Reginald,Stephenson,Male,erikaball@example.net,+1-832-500-6044x475,2010-02-08,Contracting civil engineer
84,bff9853aFAeF772,Douglas,Reese,Female,nixonvanessa@example.net,001-834-660-8312x9864,1961-11-11,Higher education lecturer
85,E883773cA5219Be,Helen,Williamson,Female,melvin08@example.net,001-377-726-4229,1911-08-11,"Lecturer, further education"
86,CB19EafEbBfF9eC,Mario,Vaughn,Male,oblake@example.com,160-144-5039x12276,1990-07-08,Research scientist (life sciences)
87,5834700fbEd2771,Chelsea,Dickson,Male,johnnyhendricks@example.net,001-698-651-0138x18588,1958-05-13,"Teacher, early years/pre"
88,2b0Ab1Dc9E01D7E,Dustin,Bailey,Male,pbarron@example.net,+1-965-621-1157x345,1908-08-22,Travel agency manager
89,3f3a3D89ad042Dd,Harry,Medina,Female,olsenmalik@example.net,+1-451-099-5805,1947-08-24,Technical sales engineer
90,9425E2F38C408ef,Kathy,Haney,Female,teresa37@example.com,(164)105-8456,1955-09-02,Charity fundraiser
91,F0aeC9c2759F3C6,Alison,Nixon,Female,zmiles@example.net,3506680871,1941-07-10,Patent attorney
92,d6EA619A7C4aA95,Jamie,Hardy,Female,sheenadouglas@example.com,(900)803-9295x11533,1994-07-17,"Conservator, furniture"
93,2A33E7Cad1bb0F5,Melody,Cox,Female,evan90@example.org,(626)520-5080x3511,1974-07-30,Dance movement psychotherapist
94,d181FFB7d3E68bb,Xavier,Cole,Male,nicolas90@example.org,8164259975,1938-11-29,Financial planner
95,feaBf8dAE0C0d6F,Dillon,Guzman,Female,angelanavarro@example.net,971-992-4521,1942-04-01,Air broker
96,5eFda7caAeB260E,Dennis,Barnes,Female,bmartin@example.org,001-095-524-2112x257,1954-07-30,Software engineer
97,CCbFce93d3720bE,Steve,Patterson,Female,latasha46@example.net,001-865-478-5157,1932-04-29,Barrister
98,2fEc528aFAF0b69,Wesley,Bray,Male,regina11@example.org,995-542-3004x76800,1994-12-28,Police officer
99,Adc7ad9B6e4A1Fe,Summer,Oconnell,Female,alexiscantrell@example.org,001-273-685-6932x092,2012-04-12,Broadcast journalist
100,b8D0aD3490FC7e1,Mariah,Bernard,Male,pcopeland@example.org,(341)594-6554x44657,2016-11-15,IT sales professional
```

</details>
  
