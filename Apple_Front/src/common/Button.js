import React from 'react';
import styled, {css} from 'styled-components';
import './Button.css';

// 페이지에서 사용하는 버튼 타입 정리
// size - default, small, xsmall
// color - blue, none, red


// size css
const sizeStyles = css`
    ${props =>
        props.size === 'default' &&
        css`
            width: 110px;
            height: 40px;
            font-size: 16px;
            padding: 8px 13px 5px 12px;
        `
    }
    ${props =>
        props.size === 'large' &&
        css`
            width: 300px;
            height: 40px;
            font-size: 16px;
            padding: 8px 13px 5px 12px;
        `
    }
    ${props =>
        props.size === 'small' &&
        css`
            width: 90px;
            height: 35px;
            font-size: 14px;
        `
    }
    ${props =>
        props.size === 'xsmall' &&
        css`
            width: 70px;
            height: 38px;
            font-size: 14px;
        `
    }
`;

// size css
const colorStyles = css`
    ${props =>
        props.color === 'blue' &&
        css`
            border: 1px solid #0071e3;
            background-color: #0071e3;
            color: white;
        `
    }
    ${props =>
        props.color === 'none' &&
        css`
            border: 1px solid;
            border-color: #0071e3;
            background-color: transparent;
            color: #0071e3;
        `
    }
    ${props =>
        props.color === 'red' &&
        css`
            border: 0;
            border-color: #d84a4a;
            background-color: #d84a4a;
            color: white;
        `
    }
`;

const StyledButton = styled.button`
    border-radius: 20px;
    margin-left: 10px;
    margin-right: 10px;
    vertical-align: middle;
    border: 1px solid #0071e3;
    background-color: #0071e3;
    color: white;
    
    
    ${sizeStyles}
    ${colorStyles}
`;



function Button ({text, size, color, onClick}) {

    return <StyledButton size={size} color={color} onClick={onClick}> {text} </StyledButton>
}

export default Button;