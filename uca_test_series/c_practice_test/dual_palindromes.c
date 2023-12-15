#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

/* is string s a palindrome? */
int ispal(char *s)
{
    char *t;

    for(t=s+strlen(s)-1; s<t; s++, t--)
        if(*s != *t)
	        return 0;

    return 1;
}

/* put the base b representation of n into s: 0 is represented by "" */
char*
numbconv(char *s, int n, int b)
{
    int len;

    if(n == 0) {
        strcpy(s, "");
        return s;
    }

    /* figure out first n-1 digits */
    numbconv(s, n/b, b);

    /* add last digit */
    len = strlen(s);
    s[len] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"[n%b];
    s[len+1] = '\0';
    return s;
}

/* is number n a dual palindrome? */
int isdualpal(int n)
{
    int i, npal;
    char s[40];

    npal = 0;
    for(i=2; i<=10; i++)
	    if(ispal(numbconv(s, n, i)))
	        npal++;

    return npal >= 2;
}

int main(void)
{
    int n, s;

    scanf("%d %d", &n, &s);

    for(s++; n>0; s++) {
	    if(isdualpal(s)) {
	        printf("%d\n", s);
            n--;
        }
    }

    return 0;
}