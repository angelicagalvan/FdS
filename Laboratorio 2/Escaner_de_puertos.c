 #include <errno.h>
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
 
int main(int argc, char *argv[]) {                  
 
	int sockid;    
	int connid;    
	int con = 1;  
	int puertoa = 0;    
 
	struct sockaddr_in conect; 
 	
	conect.sin_family = AF_INET;
	conect.sin_addr.s_addr = inet_addr("127.0.0.1");
	bzero(&(conect.sin_zero), 8);
	printf("\n\n");
 	printf("Puerto ........... Estado \n");
	printf("\n\n");
	for (con = 0; con != 9000; con++) {
 	     sockid = socket(AF_INET,SOCK_STREAM,0);
             conect.sin_port = htons(con);
             connid = connect(sockid, (struct sockaddr *)&conect, sizeof(struct sockaddr));
 
	     if (connid != -1) {
 
		printf(" %d........... Abierto \n",con);
		puertoa++;
		close(connid);
		
	     }
	     close(sockid);
	}
 
printf("\n\n");
printf("\n\n");
printf(" %d Puertos Abiertos",puertoa);
printf("\n\n");

 
return 0;
}
