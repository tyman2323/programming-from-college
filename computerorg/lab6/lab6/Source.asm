.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
ArrayB WORD 1,2,3,4
holder WORD 0

.code
main proc
	mov ax, ArrayB[0]
	mov holder, ax
	mov ax, ArrayB[6]
	mov ArrayB[0], ax
	mov ax, holder
	mov ArrayB[6], ax
	mov ax, ArrayB
	mov bx, ArrayB[6]
	
	mov ax, ArrayB[2]
	mov holder, ax
	mov ax, ArrayB[4]
	mov ArrayB[2], ax
	mov ax, holder
	mov ArrayB[4], ax
	
	INVOKE ExitProcess,0
main ENDP
END main


