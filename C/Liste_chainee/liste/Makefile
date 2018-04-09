CC = gcc
OBJS = liste.o 
CFLAGS = -c -Wall -ansi -pedantic
LDFLAGS =
PGM = liste

all: $(PGM)

$(PGM): $(OBJS)
	$(CC) $(LDFLAGS) -o $(PGM) $(OBJS)
.c.o:
	$(CC) $(CFLAGS) $<

clean :
	rm -f $ ( PGM )
	rm -f $ ( OBJS )
	rm -f *~
