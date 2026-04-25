#include <stdio.h>

int main() {
    int initial := 10;
    int rate := 5;

    int position := initial + rate * 60;

    if (position == 310) {
        printf("ok\n");
    }

    return 0;
}
