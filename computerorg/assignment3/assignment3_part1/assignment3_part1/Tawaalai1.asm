.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword
;Ayman Tawaalai
;CSC 3210
;Assignment 3
;This program will have an inputStray of letters and flip them back to front and within that flip itll do another local flip between two 
.data
inputStr word "A", "B", "C", "D", "E", "F", "G", "H"
index byte 0

.code
main proc
	mark:
	mov eax, Lengthof inputStr
	mov ebx, 2
	mov ecx, 0
	mov edx, 0
	test eax, 1
	jz bruhv
	sub eax,1
	bruhv:
	div ebx
	XCHG ecx, eax
	mov ebx, lengthof inputStr
	sub ebx, 1
	add ebx, ebx
	cmp index, dl
	jg bruh
	l1:
		movsx esi, index
		mov ax, inputStr[esi]
		mov dx, inputStr[ebx]
		XCHG ax, dx
		mov inputStr[esi], ax
		mov inputStr[ebx], dx
		add index, 2
		sub bx, 2
		loop l1
	jmp mark
	bruh:
	mov esi, 0
	bruhfinal:
	mov ax, inputStr[esi]
	xchg inputStr[esi+2], ax
	mov inputStr[esi], ax
	add esi, 4
	loop bruhfinal
		
	INVOKE ExitProcess,0
main ENDP
END main


