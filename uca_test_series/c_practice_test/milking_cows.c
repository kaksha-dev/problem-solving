#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

#define MAXMILKING 5000

typedef struct Milking	Milking;
struct Milking {
    int begin;
    int end;
};

Milking milking[MAXMILKING];
int nmilking;

int milkcmp(const void *va, const void *vb)
{
    Milking *a, *b;

    a = (Milking*)va;
    b = (Milking*)vb;

    if(a->begin > b->begin)
        return 1;
    if(a->begin < b->begin)
        return -1;
    return 0;
}

int main(void)
{
    int i, t, tmilk, tnomilk;
    Milking cur;

    /* read input, sort */
    scanf("%d", &nmilking);
    for(i=0; i<nmilking; i++) {
        scanf("%d %d", &milking[i].begin, &milking[i].end);
    }

    qsort(milking, nmilking, sizeof(Milking), milkcmp);

    /* walk over list, looking for long periods of time */
    /* tmilk = longest milking time */
    /* tnomilk = longest non-milking time */
    /* cur = current span of milking time being considered */

    tmilk = 0;
    tnomilk = 0;
    cur = milking[0];
    for(i=1; i<nmilking; i++) {
        if(milking[i].begin > cur.end) {	/* a down time */
            t = milking[i].begin - cur.end;
            if(t > tnomilk)
                tnomilk = t;
            
            t = cur.end - cur.begin;
            if(t > tmilk)
                tmilk = t;
            cur = milking[i];
        } 
        else {	
            if(milking[i].end > cur.end)
                cur.end = milking[i].end;
            }
    }

    /* check final milking period */
    t = cur.end - cur.begin;
    if(t > tmilk)
        tmilk = t;

    printf("%d %d\n", tmilk, tnomilk);
    return 0;
}