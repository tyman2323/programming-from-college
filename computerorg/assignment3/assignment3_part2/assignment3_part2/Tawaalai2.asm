.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword
;Ayman Tawaalai
;CSC 3210
;Assignment 3
;This program uses pointers to subdivide a 64 bit variable and add up all those subdivisions into a single register
.data
qval qword 0506030704080102h

.code
main proc
	mov eax, 0
	mov ax, word ptr qval ;subdivided 0102
	add ax, word ptr qval[2] ;subdivided 0408
	add ax, word ptr qval[4] ;subdivided 0307
	add ax, word ptr qval[6] ;subdivided 0506

	
	INVOKE ExitProcess,0
main ENDP
END main


