#include <mega128.h>
#include <delay.h>
void main(void)
{
    int i;
    unsigned char led;
    DDRC = 0xFF;
    while(1)
    {
            led = 0xFF;
        for(i=0; i<8; i++)
        {
            PORTC = led;
            delay_ms(500);
            PORTC = led >>= 1;
        }
}   
        }