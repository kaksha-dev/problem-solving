#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//works for any data type. do not change this method for any testing. As it is s generic method
void swap(void *a[], int i, int j)
{
    void *temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
//works for any data type. do not change this method for any testing. As it is s generic method
void quick_sort(void *a[], int L, int R, int (*cmp)(void *, void *))
{
    if (L >= R)
        return;
    int p = L;
    int i = L + 1;
    for (; i <= R; i++)
    {
        if ((*cmp)(a[i], a[L]) < 0)
        {
            swap(a, i, ++p);
        }
    }
    swap(a, p, L);
    quick_sort(a, L, p - 1, cmp);
    quick_sort(a, p + 1, R, cmp);
}

struct student
{
    int id;
    char name[10];
};


int intCmp(void *x, void *y)
{
    int *i = (int *)(x);
    int *j = (int *)(y);
    if (*i == *j)
        return 0;
    if (*i > *j)
        return +1;
    return -1;
}

int floatCmp(void *x, void *y)
{
    float *i = (float *)(x);
    float *j = (float *)(y);
    if (*i == *j)
        return 0;
    if (*i > *j)
        return +1;
    return -1;
}
int studentIdCmp(void *x, void *y)
{
    struct student *i = (struct student *)(x);
    struct student *j = (struct student *)(y);
    if (i->id == j->id)
        return 0;
    if (i->id > j->id)
        return +1;
    return -1;
}

int studentNameCmp(void *x, void *y)
{
    struct student *i = (struct student *)(x);
    struct student *j = (struct student *)(y);
    return strcmp(i->name, j->name);
}



void test_float_sorting()
{
    printf("testing float sorting\n");
    float **b = (float **)(malloc(sizeof(float *) * 5));

    int i;

    for (i = 0; i < 5; i++)
    {
        printf("enter input:");
        float *num = (float *)(malloc(sizeof(float *)));
        scanf("%f", num);
        b[i] = num;
    }
    printf("unsorted data : ");
    for (int i = 0; i < 5; i++)
    {
        printf("%f->", *b[i]);
    }
    quick_sort((void **)b, 0, 4, (int (*)(void *, void *))floatCmp);
    printf("sorted data : ");
    printf("\n");
    for (int i = 0; i < 5; i++)
    {
        printf("%f->", *b[i]);
    }
    printf("\n");
}
void test_int_sorting()
{
    printf("testing int sorting\n");
    int **b = (int **)(malloc(sizeof(int *) * 5));

    int i;

    for (i = 0; i < 5; i++)
    {
        printf("enter input:");
        int *num = (int *)(malloc(sizeof(int *)));
        scanf("%d", num);
        b[i] = num;
    }
    printf("unsorted data : ");
    for (int i = 0; i < 5; i++)
    {
        printf("%d->", *b[i]);
    }
    quick_sort((void **)b, 0, 4, (int (*)(void *, void *))intCmp);
    printf("\n");
    printf("sorted data :");
    for (int i = 0; i < 5; i++)
    {
        printf("%d->", *b[i]);
    }
    printf("\n");
}
void test_student_sorting()
{
    printf("testing student sorting\n");
    struct student **b = (struct student **)(malloc(sizeof(struct student *) * 5));

    int i;

    for (i = 0; i < 5; i++)
    {
        struct student *s = (struct student *)(malloc(sizeof(struct student *)));
        printf("enter input (id):");
        scanf("%d", &s->id);
        printf("enter input (name):");
        scanf("%s", &s->name);

        b[i] = s;
    }
    printf("unsorted data : ");
    for (int i = 0; i < 5; i++)
    {
        printf("%d(%s)->", b[i]->id, b[i]->name);
    }
    quick_sort((void **)b, 0, 4, (int (*)(void *, void *))studentIdCmp);
    printf("\n");
    printf("sorted data by id :");
    for (int i = 0; i < 5; i++)
    {
        printf("%d(%s)->", b[i]->id, b[i]->name);
    }
    printf("\n");
    quick_sort((void **)b, 0, 4, (int (*)(void *, void *))studentNameCmp);
    printf("\n");
    printf("sorted data by name :");
    for (int i = 0; i < 5; i++)
    {
        printf("%d(%s)->", b[i]->id, b[i]->name);
    }
    printf("\n");
}
int main()
{
    test_int_sorting();
    test_float_sorting();
    test_student_sorting();
}